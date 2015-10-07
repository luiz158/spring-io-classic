package pl.pragmatists.customer

import org.springframework.stereotype.Service

@Service
class CustomerService {

    static Iterable<Customer> customers = new ArrayList<>()

    static {
        // TODO Dummy data is provided here. To be removed.
        customers.add(new Customer(
            firstName: 'Paweł',
            lastName: 'Barszcz',
            creditCard: '123abc'
        ))
    }

    Customer findByCreditCard(String creditCard) {
        if (!creditCard) {
            throw new CreditCardNotProvidedException()
        }
        return customers.stream()
            .filter({ customer -> customer.creditCard == creditCard })
            .findFirst()
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
