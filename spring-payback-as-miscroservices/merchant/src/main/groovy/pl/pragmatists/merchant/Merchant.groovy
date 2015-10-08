package pl.pragmatists.merchant

import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
@ToString
class Merchant {

    @Id
    @GeneratedValue
    Long id;

    String name

    BigDecimal percentage

    BigDecimal minAmount

    BigDecimal maxPayback

}
