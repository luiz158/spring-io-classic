package classic.customer

import groovy.transform.ToString
import org.springframework.data.jpa.domain.AbstractPersistable

import javax.persistence.Entity

@Entity
@ToString
class Customer extends AbstractPersistable<Long> {

    String firstName

    String lastName

    String creditCard

    @Override
    public void setId(Long id) {
        super.setId(id)
    }
}