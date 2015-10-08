package pl.pragmatists.merchant

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
class MerchantController {

    @Autowired
    MerchantService merchantService

    @RequestMapping(method = GET, value = '/merchants')
    def findByCreditCard() {
        return merchantService.findAll()
    }
}
