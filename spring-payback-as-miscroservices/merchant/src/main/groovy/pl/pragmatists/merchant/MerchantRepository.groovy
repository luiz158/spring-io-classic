package pl.pragmatists.merchant

import org.springframework.data.jpa.repository.JpaRepository

interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
