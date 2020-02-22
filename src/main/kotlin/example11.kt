import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    exampleAsyncAwait11()
}

suspend fun calculateHardThings11(startNum: Int): Int {
    delay(1000)
    return startNum * 10
}


fun exampleAsyncAwait11() = runBlocking {
    val startTime = System.currentTimeMillis()

    /**
     * In this example, we are not running coroutines in parallel.
     * The time taken to calculate sum will be more than 3 secs
     */
    val deferred1 = async { calculateHardThings(10) }.await()
    val deferred2 = async { calculateHardThings(20) }.await()
    val deferred3 = async { calculateHardThings(30) }.await()

    /**
     * Extracting results from coroutines
     */
    val sum = deferred1 + deferred2 + deferred3
    println("async/await sum = ${sum}" )

    val endTime = System.currentTimeMillis()
    println("Time taken: ${endTime - startTime}")
}

