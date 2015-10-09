package pl.pragmatists.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
class CustomerApplication {

    static void main(String[] args) {
        SpringApplication.run CustomerApplication, args
    }

    @Autowired
    CustomerRepository customerRepository

    @Bean
    HealthIndicator customHealthIndicator() {
        return {
            Health.outOfService().build()
        }
    }
}

@Component
class DbPopulator {

    @Autowired
    CustomerRepository customerRepository

    @PostConstruct
    void populateDb() {
        customerRepository.save(new Customer(
            firstName: "Paweł",
            lastName: 'Barszcz',
            creditCard: '123abc'
        ))
        customerRepository.save(new Customer(
            firstName: "Ola",
            lastName: 'Barszcz',
            creditCard: 'xyz'
        ))
    }

}

@ConfigurationProperties(prefix = 'customerProps')
@Component
class CustomerProperties {

    def firstNameSuffix
}
