package pl.pragmatists.payback

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import groovy.transform.ToString

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
class PaybackGiver {

    BigDecimal percentage

    BigDecimal minAmount

    BigDecimal maxPayback

}
