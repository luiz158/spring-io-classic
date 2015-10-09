package pl.pragmatists.payback

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class PaybackReceiver {

    Long id;

    String creditCard

}
