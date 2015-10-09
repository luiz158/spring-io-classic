package pl.pragmatists.payback.remote

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import pl.pragmatists.payback.PaybackGiver
import pl.pragmatists.payback.PaybackReceiver

@Component
class IntegrationClient {

    @Autowired
    MerchantClient merchantClient
    @Autowired
    CustomerClient customerClient

    @HystrixCommand(fallbackMethod = 'findReceiverByCreditCardFallback')
    PaybackReceiver findReceiverByCreditCard(String creditCard) {
        return customerClient.findCustomerByCreditCard(creditCard)
    }

    @HystrixCommand(fallbackMethod = 'findGiverMerchantByIdFallback')
    PaybackGiver findGiverMerchantById(Long id) {
        return merchantClient.findMerchantById(id)
    }

    @SuppressWarnings("GroovyUnusedDeclaration")
    PaybackReceiver findReceiverByCreditCardFallback(String creditCard) {
        return new PaybackReceiver(
            id: 99999,
            creditCard: 'DUMMY_CREDIT_CARD'
        )
    }

    @SuppressWarnings("GroovyUnusedDeclaration")
    PaybackGiver findGiverMerchantByIdFallback(Long id) {
        return new PaybackGiver(
            percentage: new BigDecimal(0),
            minAmount: new BigDecimal(0),
            maxPayback: new BigDecimal(0)
        )
    }
}
