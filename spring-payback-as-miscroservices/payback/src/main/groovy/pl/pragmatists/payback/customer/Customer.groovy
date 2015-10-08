package pl.pragmatists.payback.customer

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Customer {

    Long id;

    String firstName

    String lastName

    String creditCard
}
