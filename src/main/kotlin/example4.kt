import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    blockingExample4()
}

suspend fun printlnDelayed4(message: String) {
    delay(2000)
    println(message)
}

/**
 * Dispatchers.Default executes runBlock in different thread but it still blocks main thread.
 */
fun blockingExample4() {
    println("one - from thread ${Thread.currentThread().name}")
    runBlocking(Dispatchers.Default) {
        printlnDelayed4("two - from thread ${Thread.currentThread().name}")
    }
    println("three - from thread ${Thread.currentThread().name}")
}
