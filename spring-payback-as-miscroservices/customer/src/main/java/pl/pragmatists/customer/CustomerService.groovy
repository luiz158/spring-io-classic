package pl.pragmatists.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService {

    @Autowired
    CustomerRepository customerRepository

    List<Customer> findAll() {
        return customerRepository.findAll()
    }

    Customer findByCreditCard(String creditCard) {
        if (!creditCard) {
            throw new CreditCardNotProvidedException()
        }
        return Optional.ofNullable(customerRepository.findByCreditCard(creditCard))
            .orElseThrow({ -> new UserNotFoundException("No user found with credit card '${creditCard}'") })
    }

    static class CreditCardNotProvidedException extends Exception {
        CreditCardNotProvidedException() {
            super('No credit card provided')
        }
    }

    static class UserNotFoundException extends Exception {
        UserNotFoundException(String reason) {
            super(reason)
        }
    }
}
