package ru.test.demo

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageResource(private val service: MessageService) {

    @GetMapping("/")
    @ResponseBody
    fun index():List<Person>
    {
        return service.findMessages()
    }
}
