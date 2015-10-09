package pl.pragmatists.payback.remote

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import pl.pragmatists.payback.PaybackReceiver

import static org.springframework.web.bind.annotation.RequestMethod.GET

@FeignClient('customer')
interface CustomerClient {

    @RequestMapping(method = GET, value = '/customers')
    List<PaybackReceiver> findAll()

    @RequestMapping(method = GET, value = '/customer')
    PaybackReceiver findCustomerByCreditCard(@RequestParam(value = 'creditCard') String creditCard)

}
