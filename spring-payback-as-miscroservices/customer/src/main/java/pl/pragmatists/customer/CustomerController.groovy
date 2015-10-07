package pl.pragmatists.customer

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
class CustomerController {

    @RequestMapping(method = GET, value = '/customer')
    def findByCreditCard() {
        return new Customer(
            firstName: 'Paweł',
            lastName: 'Barszcz',
            creditCard: '123abc'
        )
    }
}
