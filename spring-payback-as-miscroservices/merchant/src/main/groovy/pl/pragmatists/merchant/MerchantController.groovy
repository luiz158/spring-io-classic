package pl.pragmatists.merchant

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletResponse

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
class MerchantController {

    @Autowired
    MerchantService merchantService

    @RequestMapping(method = GET, value = '/merchants')
    def findAll() {
        return merchantService.findAll()
    }

    @RequestMapping(method = GET, value = '/merchants/{id}')
    def findById(@PathVariable Long id) {
        return merchantService.findById(id)
    }

    @ExceptionHandler(MerchantNotFoundException)
    def handleUserNotFoundException(MerchantNotFoundException exception,
                                    HttpServletResponse response) {
        response.sendError(NOT_FOUND.value(), exception.getMessage())
    }
}
