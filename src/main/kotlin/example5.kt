import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    exampleGlobalLaunch()
}

suspend fun printlnDelayed5(message: String) {
    delay(2000)
    println(message)
}

fun exampleGlobalLaunch() = runBlocking {
    println("one - from thread ${Thread.currentThread().name}")

    /**
     * GlobalLaunch runs the block code in separate thread.
     */
    GlobalScope.launch {
        printlnDelayed5("two - from thread ${Thread.currentThread().name}")
    }
    println("three - from thread ${Thread.currentThread().name}")

    /**
     * Waiting for GlobalScope to finish execution and report back
     */
    delay(3000)
}
