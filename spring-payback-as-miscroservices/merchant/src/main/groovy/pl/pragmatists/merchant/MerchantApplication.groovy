package pl.pragmatists.merchant

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
class MerchantApplication {

    static void main(String[] args) {
        SpringApplication.run MerchantApplication, args
    }
}

@Component
class DbPopulator {

    @Autowired
    MerchantRepository merchantRepository

    @PostConstruct
    void populateDb() {
        merchantRepository.save(new Merchant(
            name: 'Empik',
            percentage: new BigDecimal(25.0),
            minAmount: new BigDecimal(10.0),
            maxPayback: new BigDecimal(50.0)
        ))
        merchantRepository.save(new Merchant(
            name: 'BP',
            percentage: new BigDecimal(8.0),
            minAmount: new BigDecimal(123.0),
            maxPayback: new BigDecimal(98.0)
        ))
    }

}
