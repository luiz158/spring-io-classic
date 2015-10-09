package pl.pragmatists.payback

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
class PaybackApplication {

    static void main(String[] args) {
        SpringApplication.run PaybackApplication, args
    }
}

@Component
class DbPopulator {

    @Autowired
    PaybackRepository paybackRepository

    @PostConstruct
    void populateDb() {
        paybackRepository.save(new Payback(
            customerId: 123,
            amount: new BigDecimal(100.0)
        ))
        paybackRepository.save(new Payback(
            customerId: 999,
            amount: new BigDecimal(0.9)
        ))
    }

}

