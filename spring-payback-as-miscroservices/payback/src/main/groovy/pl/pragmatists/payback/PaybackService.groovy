package pl.pragmatists.payback

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pl.pragmatists.payback.purchase.Purchase
import pl.pragmatists.payback.remote.MerchantClient

import static java.math.BigDecimal.ZERO

@Service
class PaybackService {

    @Autowired
    PaybackRepository paybackRepository
    @Autowired
    MerchantClient merchantClient

    Iterable<Payback> findAll() {
        return paybackRepository.findAll()
    }

    void addPaybackFor(Purchase purchase) {
        println purchase
        println paybackFor(purchase)
    }

    BigDecimal paybackFor(Purchase purchase) {
//        return Optional.<Purchase>of(purchase)
//            .filter { it -> percentage != null && it.getAmount() != null }
//            .filter { it -> minAmount == null || minAmount.compareTo(it.getAmount()) <= 0 }
//            .map { it -> percentage.multiply(it.getAmount(), DECIMAL32) }
//            .map { it -> maxPayback != null && maxPayback.compareTo(it) < 0 ? maxPayback : it }
//            .orElse(ZERO);
        return ZERO;
    }
}
