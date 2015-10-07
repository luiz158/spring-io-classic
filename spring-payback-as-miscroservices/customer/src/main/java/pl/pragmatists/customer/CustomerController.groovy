package pl.pragmatists.customer

import org.springframework.beans.factory.annotation.Autowired
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

    @RequestMapping(method = GET, value = '/customer')
    def findByCreditCard(@RequestParam(required = false) String creditCard) {
        return customerService.findByCreditCard(creditCard)
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
