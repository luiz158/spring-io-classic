package pl.pragmatists.payback.purchase

import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
class Purchase {

    BigDecimal amount

    String creditCardNumber

    Long merchantId
}
