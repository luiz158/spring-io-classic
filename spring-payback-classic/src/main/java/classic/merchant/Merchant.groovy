package classic.merchant

import groovy.transform.ToString
import org.springframework.data.jpa.domain.AbstractPersistable
import classic.payback.Purchase

import javax.persistence.Entity

import static java.math.BigDecimal.ZERO
import static java.math.MathContext.DECIMAL32

@Entity
@ToString
class Merchant extends AbstractPersistable<Long> {

    String name

    BigDecimal percentage

    BigDecimal minAmount

    BigDecimal maxPayback

    @Override
    public void setId(Long id) {
        super.setId(id)
    }

    BigDecimal paybackFor(Purchase purchase) {
        return Optional.of(purchase)
            .filter { it -> percentage != null && it.getAmount() != null }
            .filter { it ->  minAmount == null || minAmount.compareTo(it.getAmount()) <= 0 }
            .map { it -> percentage.multiply(it.getAmount(), DECIMAL32) }
            .map { it -> maxPayback != null && maxPayback.compareTo(it) < 0 ? maxPayback : it }
            .orElse(ZERO);
    }
}
