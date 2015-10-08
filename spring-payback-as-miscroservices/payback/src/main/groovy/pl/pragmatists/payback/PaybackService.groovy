package pl.pragmatists.payback

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PaybackService {

    @Autowired
    PaybackRepository paybackRepository

    Iterable<Payback> findAll() {
        return paybackRepository.findAll()
    }
}
