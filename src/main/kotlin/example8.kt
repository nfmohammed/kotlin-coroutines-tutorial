import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    exampleLaunchCoroutineScope8()
}

suspend fun printlnDelayed8(message: String) {
    delay(2000)
    println(message)
}


fun exampleLaunchCoroutineScope8() = runBlocking {
    println("one - from thread ${Thread.currentThread().name}")

    /**
     * blocking code executed within this coroutine scope
     * With default dispatcher, the blocking code runs in separate thread.
     * Other example: Dispathcers.IO
     */
    launch(Dispatchers.Default) {
        printlnDelayed8("two - from thread ${Thread.currentThread().name}")
    }

    println("three - from thread ${Thread.currentThread().name}")
}
