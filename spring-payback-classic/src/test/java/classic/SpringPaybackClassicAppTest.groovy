package classic

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(classes = SpringPaybackClassicAppConfig)
@WebAppConfiguration
class SpringPaybackClassicAppTest {

    @Test
    void contextLoads() {
    }

}
