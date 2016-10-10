package io.hosshan

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by shunhosaka on 2016/10/11.
 */
@Controller
@EnableAutoConfiguration
open class MainController {

    @RequestMapping("/")
    @ResponseBody
    open fun home(): String =
            "Hello, Spring Boot Sample Application!"

}