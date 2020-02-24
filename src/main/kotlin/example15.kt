import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    example15()
}

fun example15() = runBlocking {
    val job = launch {
        while(isActive) {
            delay(100)
            println("is Working")
        }
    }
    delay(2000)
    job.cancel() //Coroutine is cancelled here.
}
