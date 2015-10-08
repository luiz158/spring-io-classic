package pl.pragmatists.customer

import org.springframework.boot.SpringApplication
import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class CustomerApplication {

    static void main(String[] args) {
        SpringApplication.run CustomerApplication, args
    }

    @Bean
    HealthIndicator customHealthIndicator() {
        return {
            Health.outOfService().build()
        }
    }
}
