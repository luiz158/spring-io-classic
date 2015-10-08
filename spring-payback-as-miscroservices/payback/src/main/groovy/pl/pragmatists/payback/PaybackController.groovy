package pl.pragmatists.payback

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
class PaybackController {

    @Autowired
    PaybackService paybackService

    @RequestMapping(method = GET, value = '/paybacks')
    def findAll() {
        return paybackService.findAll()
    }
}
