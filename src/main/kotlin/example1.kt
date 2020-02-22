fun main() {
    blockingExample1()
}

fun blockingExample1() {
    println("one")
    printlnDelayed1("two")
    println("three")
}

/**
 * Traditional way of writing blocking code
 */
fun printlnDelayed1(message: String) {
    Thread.sleep(2000)
    println(message)
}
