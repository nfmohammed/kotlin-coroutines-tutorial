import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    blockingExample2()
}

/**
 * Since this is a blocking code, we use keyword suspend
 */
suspend fun printlnDelayed2(message: String) {
    delay(2000)
    println(message)
}

/**
 * Rewriting the same example1 but in kotlin syntax
 */
fun blockingExample2() {
    println("one")
    runBlocking {
        printlnDelayed2("two")
    }
    println("three")
}
