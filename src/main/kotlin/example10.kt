import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    exampleAsyncAwait()
    example2AsyncAwait()
    example3LazyCoroutine()
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

/**
 * Second example: running expensive jobs concurrently and getting back results
 */
fun example2AsyncAwait() = runBlocking {
    val delay = 1000L
    val time = measureTimeMillis {

        /**
         * Two expensive operations are submitted here
         */
        val one = async { calculateHardThings(10) }
        val two = async { calculateHardThings(20) }

        /**
         * coroutine is suspended here until we get back the results
         */
        runBlocking {
            one.await()
            two.await()
        }
    }
    println("Processing time = ${time} and it should be less than ${2*delay}")
}

/**
 * Example 3: illustrates Lazy coroutine i.e. coroutine is initiated after await is called.
 */
fun example3LazyCoroutine() = runBlocking {
    val delay = 1000L
    val time = measureTimeMillis {

        /**
         * Defining lazy coroutines
         */
        val one = async(Dispatchers.Default, CoroutineStart.LAZY) { calculateHardThings(10) }
        val two = async(Dispatchers.Default, CoroutineStart.LAZY){ calculateHardThings(20) }

        /**
         * This code is executed in blocking manner
         */
        runBlocking {
            /**
             * First coroutine started here. The execution is blocked until we get back results from coroutine.
             */
            one.await()

            /**
             * Second coroutine started after the first is finished.
             */
            two.await()
        }

    }
    println()
    println("Time taken to execute sequentially ${time} will be greater than ${2*delay}")
}
