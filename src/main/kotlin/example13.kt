import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    example13()
}

suspend fun expensiveComputation(res: MutableList<String>){
    delay(2000)
    res.add("world")
}

fun example13() {
    val res = mutableListOf<String>()
    res.add("Hello")
    println(res) //Hello is printed
    runBlocking {
        val promise = launch {
            expensiveComputation(res)
        }
        promise.join()
    }
    println("This statement waits for runBlocking to complete")
    println(res)
}
