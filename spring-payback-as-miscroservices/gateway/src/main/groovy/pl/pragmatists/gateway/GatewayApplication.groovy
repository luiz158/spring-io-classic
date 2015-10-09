package pl.pragmatists.gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
class GatewayApplication {

    static void main(String[] args) {
        SpringApplication.run GatewayApplication, args
    }
}
