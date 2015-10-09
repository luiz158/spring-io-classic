package pl.pragmatists.payback

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class PaybackGiver {

    Long id;

    BigDecimal percentage

    BigDecimal minAmount

    BigDecimal maxPayback

}
