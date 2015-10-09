package pl.pragmatists.dashboard

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard
import org.springframework.cloud.netflix.turbine.EnableTurbine

@EnableHystrixDashboard
@EnableTurbine
@SpringBootApplication
class HystrixDashboardApplication {

    static void main(String[] args) {
        SpringApplication.run HystrixDashboardApplication, args
    }
}
