import kotlinx.coroutines.*

fun main() {
    exampleAsyncAwait12()
}

suspend fun calculateHardThings12(startNum: Int): Int {
    delay(1000)
    return startNum * 10
}


fun exampleAsyncAwait12() = runBlocking {
    val startTime = System.currentTimeMillis()

    /**
     * In this example, we are not running coroutines in parallel.
     * This coroutines will run sequentially
     */
    val result1 = withContext(Dispatchers.Default){ calculateHardThings(10) }
    val result2 = withContext(Dispatchers.Default){ calculateHardThings(20) }
    val result3 = withContext(Dispatchers.Default){ calculateHardThings(30) }

    /**
     * No need await for results
     */
    val sum = result1 + result2 + result3
    println("async/await sum = ${sum}" )

    val endTime = System.currentTimeMillis()
    println("Time taken: ${endTime - startTime}")
}

