import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    blockingExample3()
}

suspend fun printlnDelayed3(message: String) {
    delay(1000)
    println(message)
}

/**
 * Same as example2 but this is more idiomatic way
 */
fun blockingExample3() = runBlocking {
    println("one")
    printlnDelayed3("two")
    println("three")
}
