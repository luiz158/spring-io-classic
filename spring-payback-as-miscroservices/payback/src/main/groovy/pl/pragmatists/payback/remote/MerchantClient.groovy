package pl.pragmatists.payback.remote

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import pl.pragmatists.payback.PaybackGiver

import static org.springframework.web.bind.annotation.RequestMethod.GET

@FeignClient('merchant')
interface MerchantClient {

    @RequestMapping(method = GET, value = '/merchants')
    List<PaybackGiver> findAll()

    @RequestMapping(method = GET, value = '/merchants/{id}')
    PaybackGiver findMerchantById(@PathVariable(value = 'id') Long id)

}
