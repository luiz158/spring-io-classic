package pl.pragmatists.payback

import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
@ToString
class Payback {

    @Id
    @GeneratedValue
    Long id;

    Long customerId;

    BigDecimal amount;

}
