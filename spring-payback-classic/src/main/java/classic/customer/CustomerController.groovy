package classic.customer

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletResponse

@Slf4j
@RestController
@CompileStatic
@RequestMapping('/customers')
class CustomerController {

    private final CustomerService service

    @Autowired
    CustomerController(CustomerService service) {
        this.service = service
    }

    @RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    List<Customer> findAll() {
        log.info('findAll')
        return service.findAll()
    }

    @RequestMapping(value = '/{id}', method = org.springframework.web.bind.annotation.RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Customer> findOne(@PathVariable Long id) {
        log.info("findOne($id)")
        return service.findOne(id)
            .map({ org.springframework.http.ResponseEntity.ok(it) })
            .orElseGet({ org.springframework.http.ResponseEntity.notFound().build() })
    }

    @RequestMapping(value = '/findByCreditCard/{cardNo}', method = org.springframework.web.bind.annotation.RequestMethod.GET,
        produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    Customer findByCreditCard(@PathVariable String cardNo) {
        log.info("findByCreditCard($cardNo)")
        return service.findByCreditCard(cardNo)
    }

//    @ResponseStatus(CREATED)
//    @RequestMapping(value = '/', method = POST,
//        consumes = APPLICATION_JSON_VALUE)
//    ResponseEntity<Void> create(@RequestBody Customer customer) {
//        Customer saved = service.create(customer)
//        created(linkTo(methodOn(CustomerController)
//            .findOne(saved.id))
//            .toUri()).build()
//    }

    @ExceptionHandler(CustomerNotFound)
    void handleCustomerNotFound(CustomerNotFound e, HttpServletResponse response) {
        response.sendError(org.springframework.http.HttpStatus.NOT_FOUND.value(), e.message)
    }

}

@ControllerAdvice
class BusinessExceptionsHandler {

    @ExceptionHandler(CustomerNotFound)
    @ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
    void simplyHandleCustomerNotFound() {
    }
}
