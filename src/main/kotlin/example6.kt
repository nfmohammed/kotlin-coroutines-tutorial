import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    exampleGlobalLaunch6()
}

suspend fun printlnDelayed6(message: String) {
    delay(2000)
    println(message)
}

fun exampleGlobalLaunch6() = runBlocking {
    println("one - from thread ${Thread.currentThread().name}")

    /**
     * GlobalLaunch runs the block code in separate thread.
     * This time we are storing the reference for using it at later time
     */
    val job = GlobalScope.launch {
        printlnDelayed6("two - from thread ${Thread.currentThread().name}")
    }
    println("three - from thread ${Thread.currentThread().name}")

    /**
     * Waiting for GlobalScope to finish execution and report back.
     * Note: In previous example, we used `delay` to wait for GlobalLaunch to report back.
     */
    job.join()
}
