package pl.pragmatists.customer

import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Spring Data magic: I have `creditCard` in `Customer` entity so this method is working out of the box
    Customer findByCreditCard(String creditCard);
}
