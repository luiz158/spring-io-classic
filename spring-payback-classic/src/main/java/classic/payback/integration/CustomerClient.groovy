package classic.payback.integration

import classic.customer.Customer
import classic.customer.CustomerRepository
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@CompileStatic
class CustomerClient {

    private final CustomerRepository repository;

    @Autowired
    CustomerClient(CustomerRepository repository) {
        this.repository = repository;
    }

    Customer findById(Long customerId) {
        return repository.findOne(customerId);
    }

    Customer findByCreditCardNumber(String creditCardNumber) {
        return repository.findByCreditCard(creditCardNumber);
    }

}
