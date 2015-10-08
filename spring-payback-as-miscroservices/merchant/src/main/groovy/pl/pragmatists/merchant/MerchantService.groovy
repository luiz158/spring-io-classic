package pl.pragmatists.merchant

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MerchantService {

    @Autowired
    MerchantRepository merchantRepository

    Iterable<Merchant> findAll() {
        return merchantRepository.findAll()
    }
}
