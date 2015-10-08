package pl.pragmatists.merchant

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient


@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
class MerchantApplication {

    static void main(String[] args) {
        SpringApplication.run MerchantApplication, args
    }
}
