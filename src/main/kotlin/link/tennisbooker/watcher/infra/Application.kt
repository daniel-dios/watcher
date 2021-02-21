package link.tennisbooker.watcher.infra

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["link.tennisbooker.watcher.infra"])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
