package classic.payback.integration

import groovy.transform.CompileStatic
import classic.merchant.Merchant
import classic.merchant.MerchantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@CompileStatic
class MerchantClient {

    private final MerchantRepository repository;

    @Autowired
    MerchantClient(MerchantRepository repository) {
        this.repository = repository;
    }

    Merchant findOne(Long id) {
        return repository.findOne(id);
    }

}
