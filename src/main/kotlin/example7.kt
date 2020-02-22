import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    exampleLaunchCoroutineScope7()
}

suspend fun printlnDelayed7(message: String) {
    delay(2000)
    println(message)
}

/**
 * Previously, we saw example of GlobalLaunch
 * This example illustrates executing blocking code in the same thread
 */
fun exampleLaunchCoroutineScope7() = runBlocking {
    println("one - from thread ${Thread.currentThread().name}")

    /**
     * blocking code executed within this coroutine scope
     * Since no dispatcher is defined, this is executed inside main thread
     */
    launch {
        printlnDelayed7("two - from thread ${Thread.currentThread().name}")
    }

    println("three - from thread ${Thread.currentThread().name}")

    //No need for job.join() as coroutine will wait for the separate thread to finish and report back.
}
