package link.tennisbooker.watcher.infra.controller

import link.tennisbooker.watcher.usecase.LegacyService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller private constructor(val legacyService: LegacyService) {

    @GetMapping(value = ["/bookings"], produces = [MediaType.TEXT_HTML_VALUE])
    fun sayHello(@RequestParam(name = "date", required = false) date: String?): String {
        return legacyService.getBookings(date, "bookings", "date")
    }
}
