import kotlinx.coroutines.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main() {
    exampleLaunchCoroutineScope9()
}

suspend fun printlnDelayed9(message: String) {
    delay(2000)
    println(message)
}

fun exampleLaunchCoroutineScope9() = runBlocking {
    println("one - from thread ${Thread.currentThread().name}")

    /**
     * Creating custom dispatchers
     */
    val customDispatcher = Executors.newFixedThreadPool(2).asCoroutineDispatcher()

    launch(customDispatcher) {
        printlnDelayed8("two - from thread ${Thread.currentThread().name}")
    }

    println("three - from thread ${Thread.currentThread().name}")

    /**
     * Custom dispatchers do not shut down automatically.
     */
    (customDispatcher.executor as ExecutorService).shutdown()
}
