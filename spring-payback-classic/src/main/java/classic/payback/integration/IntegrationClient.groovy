package classic.payback.integration

import classic.customer.Customer
import groovy.transform.CompileStatic
import classic.merchant.Merchant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import static java.util.Optional.of

@Component
@CompileStatic
class IntegrationClient {

    private final CustomerClient customerClient;
    private final MerchantClient merchantClient;

    @Autowired
    public IntegrationClient(CustomerClient customerClient, MerchantClient merchantClient) {
        this.merchantClient = merchantClient;
        this.customerClient = customerClient;
    }

    Optional<Customer> findBustomerById(Long customerId) {
        return of(customerClient.findById(customerId));
    }

    Optional<Customer> findCustomerByCreditCard(String creditCardNumber) {
        return of(customerClient.findByCreditCardNumber(creditCardNumber));
    }

    Optional<Merchant> findMerchantById(Long metchantId) {
        return of(merchantClient.findOne(metchantId));
    }

}
