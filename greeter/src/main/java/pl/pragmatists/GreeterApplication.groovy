package pl.pragmatists

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class GreeterApplication {

    static void main(String[] args) {
        SpringApplication.run GreeterApplication, args
    }

    @Value('${greeting.text.start}')
    String greetingStart

    @Value('${greeting.text.end}')
    String greetingEnd

    @RequestMapping('/{who}')
    def greet(@PathVariable who) {
        return [
            greeting: "${greetingStart}${who}${greetingEnd}".toString(),
            timestamp: new Date()
        ]
    }
}
