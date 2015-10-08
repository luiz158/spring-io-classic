package pl.pragmatists.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.metrics.CounterService
import org.springframework.boot.actuate.metrics.GaugeService
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletResponse

import static org.springframework.http.HttpStatus.BAD_REQUEST
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
class CustomerController {

    @Autowired
    CustomerService customerService
    @Autowired
    CounterService counterService;
    @Autowired
    GaugeService gaugeService;
    @Autowired
    CustomerProperties customerProperties

    @RequestMapping(method = GET, value = '/customer')
    def findByCreditCard(@RequestParam(required = false) String creditCard) {
        counterService.increment('some.counter.value')
        gaugeService.submit("some.gauge.value", new Random().nextDouble())
        def customer = customerService.findByCreditCard(creditCard)
        customer.firstName += customerProperties.firstNameSuffix
        return customer
    }

    @ExceptionHandler(CustomerService.CreditCardNotProvidedException)
    def handleCreditCardNotProvidedException(CustomerService.CreditCardNotProvidedException exception,
                                             HttpServletResponse response) {
        response.sendError(BAD_REQUEST.value(), exception.getMessage())
    }

    @ExceptionHandler(CustomerService.UserNotFoundException)
    def handleUserNotFoundException(CustomerService.UserNotFoundException exception,
                                    HttpServletResponse response) {
        response.sendError(NOT_FOUND.value(), exception.getMessage())
    }

}
