package pl.pragmatists

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
@EnableConfigurationProperties(GreetingTextProperties)
class GreeterApplication {

    static void main(String[] args) {
        SpringApplication.run GreeterApplication, args
    }

    @Autowired
    GreetingTextProperties greetingTextProperties

    @RequestMapping('/{who}')
    def greet(@PathVariable who) {
        return [
            greeting : "${greetingTextProperties.start} ${who} ${greetingTextProperties.end}".toString(),
            timestamp: new Date()
        ]
    }
}

@ConfigurationProperties(prefix = 'greeting.text')
class GreetingTextProperties {

    String start;

    String end;
}
