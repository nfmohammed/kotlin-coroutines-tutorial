import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicInteger

fun main() {
    example14()
}

/**
 * Any number of coroutines can be started. Author used 100,000 as example.
 */
fun example14() = runBlocking {
    val counter = AtomicInteger(0)
//    val numberOfCoroutines = 100_000
    val numberOfCoroutines = 10
    val jobs = List(numberOfCoroutines) {
        launch {
            println("message fro thread = ${Thread.currentThread().name}")
            delay(100L)
            counter.incrementAndGet()
        }
    }
    jobs.forEach{ it.join() }
    println("Number of coroutines = $counter")
}
