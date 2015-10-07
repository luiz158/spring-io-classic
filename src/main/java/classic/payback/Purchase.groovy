package classic.payback

import groovy.transform.CompileStatic

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
@CompileStatic
class Purchase {

    @Column(name = "purchaseAmount")
    BigDecimal amount

    String creditCardNumber

    Long merchantId

}