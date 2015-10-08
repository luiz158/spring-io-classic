package pl.pragmatists.payback

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@EnableAutoConfiguration
@EnableDiscoveryClient
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

    @EventListener(ContextRefreshedEvent)
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

