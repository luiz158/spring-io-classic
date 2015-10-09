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

    Merchant findById(Long id) {
        return merchantRepository.findAll()
            .stream()
            .filter({ merchant -> merchant.id == id })
            .findFirst()
            .orElseThrow({ -> new MerchantNotFoundException("No merchant found with id '${id}'") })
    }
}

class MerchantNotFoundException extends Exception {
    MerchantNotFoundException(String reason) {
        super(reason)
    }
}
