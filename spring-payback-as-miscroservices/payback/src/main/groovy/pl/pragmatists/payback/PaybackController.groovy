package pl.pragmatists.payback

import com.netflix.appinfo.InstanceInfo
import com.netflix.discovery.DiscoveryClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pl.pragmatists.payback.customer.Customer
import pl.pragmatists.payback.customer.CustomerClient

import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
class PaybackController {

    @Autowired
    PaybackService paybackService
    @Autowired
    DiscoveryClient discoveryClient
    @Autowired
    CustomerClient customerClient

    @RequestMapping(method = GET, value = '/paybacks')
    def findAll() {
        return paybackService.findAll()
    }

    @RequestMapping(method = GET, value = '/discover/homepage/{applicationId}')
    String findHomePageUrlOf(@PathVariable applicationId) {
        List<InstanceInfo> instances = discoveryClient.getApplication(applicationId)?.instances
        return instances?.first()?.getHomePageUrl()
    }

    @RequestMapping(method = GET, value = '/delegated/customers')
    List<Customer> findAllCustomers() {
        return customerClient.findAll()
    }

    @RequestMapping(method = GET, value = '/delegated/customer')
    Customer findCustomerByCreditCard(@RequestParam(required = true) String creditCard) {
        return customerClient.findCustomerByCreditCard(creditCard)
    }
}
