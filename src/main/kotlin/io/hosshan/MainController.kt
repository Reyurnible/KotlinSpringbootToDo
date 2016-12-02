package io.hosshan

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Controller
 */
@Controller
@EnableAutoConfiguration
open class MainController {
    companion object {
        object Prefix {
            const val WEB = ""
            const val API = "/api/v1"
        }
    }

    // WEB
    @RequestMapping("${Prefix.WEB}/")
    @ResponseBody
    open fun home(): String =
            "Hello, Spring Boot Sample Application!"

    // API
    @RequestMapping("${Prefix.API}/todos")
    @ResponseBody
    open fun todos(): String =
            "Hello, Spring Boot Sample Application!"


}