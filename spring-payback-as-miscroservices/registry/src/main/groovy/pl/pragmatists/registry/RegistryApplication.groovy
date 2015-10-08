package pl.pragmatists.registry

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class RegistryApplication {

    static void main(String[] args) {
        SpringApplication.run RegistryApplication, args
    }
}
