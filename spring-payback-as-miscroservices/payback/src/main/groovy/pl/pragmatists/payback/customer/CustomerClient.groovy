package pl.pragmatists.payback.customer

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

import static org.springframework.web.bind.annotation.RequestMethod.GET

@FeignClient('customer')
interface CustomerClient {

    @RequestMapping(method = GET, value = '/customers')
    List<Customer> findAll()

    @RequestMapping(method = GET, value = '/customer')
    Customer findCustomerByCreditCard(@RequestParam(value = 'creditCard') String creditCard)

}
