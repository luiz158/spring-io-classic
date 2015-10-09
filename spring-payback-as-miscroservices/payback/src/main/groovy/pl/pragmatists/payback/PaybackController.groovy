package pl.pragmatists.payback

import com.netflix.appinfo.InstanceInfo
import com.netflix.discovery.DiscoveryClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pl.pragmatists.payback.purchase.Purchase
import pl.pragmatists.payback.remote.CustomerClient
import pl.pragmatists.payback.remote.MerchantClient

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

@RestController
class PaybackController {

    @Autowired
    PaybackService paybackService
    @Autowired
    DiscoveryClient discoveryClient
    @Autowired
    CustomerClient customerClient
    @Autowired
    MerchantClient merchantClient

    @RequestMapping(method = GET, value = '/paybacks')
    def findAll() {
        return paybackService.findAll()
    }

    @RequestMapping(method = GET, value = '/discover/homepage/{applicationId}')
    String findHomePageUrlOf(@PathVariable applicationId) {
        List<InstanceInfo> instances = discoveryClient.getApplication(applicationId)?.instances
        return instances?.first()?.getHomePageUrl()
    }

    @RequestMapping(method = GET, value = '/receivers')
    List<PaybackReceiver> findAllPaybackReceivers() {
        return customerClient.findAll()
    }

    @RequestMapping(method = GET, value = '/receivers/{creditCard}')
    PaybackReceiver findReceiverByCreditCard(@PathVariable String creditCard) {
        return customerClient.findCustomerByCreditCard(creditCard)
    }

    @RequestMapping(method = GET, value = '/givers')
    List<PaybackGiver> findAllPaybackGivers() {
        return merchantClient.findAll()
    }

    @RequestMapping(method = GET, value = '/givers/{giverId}')
    PaybackGiver findPaybackGiverById(@PathVariable Long giverId) {
        return merchantClient.findMerchantById(giverId)
    }

    @RequestMapping(method = POST, value = '/purchases/{creditCardNumber}/{merchantId}/{amount}')
    def addPurchase(@PathVariable String creditCardNumber,
                    @PathVariable Long merchantId,
                    @PathVariable BigDecimal amount) {
        paybackService.addPaybackFor(new Purchase(
            creditCardNumber: creditCardNumber,
            merchantId: merchantId,
            amount: amount
        ))
    }

}
