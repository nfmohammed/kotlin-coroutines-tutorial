import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    exampleAsyncAwait()
}

suspend fun calculateHardThings(startNum: Int): Int {
    delay(1000)
    return startNum * 10
}

/**
 * This example shows how data can be passed from coroutine
 */
fun exampleAsyncAwait() = runBlocking {
    val startTime = System.currentTimeMillis()

    /**
     * Starting multiple jobs that will run in parallel
     */
    val deferred1 = async { calculateHardThings(10) }
    val deferred2 = async { calculateHardThings(20) }
    val deferred3 = async { calculateHardThings(30) }

    /**
     * Extracting results from coroutines
     */
    val sum = deferred1.await() + deferred2.await() + deferred3.await()
    println("async/await sum = ${sum}" )

    val endTime = System.currentTimeMillis()
    println("Time taken: ${endTime - startTime}")
}

