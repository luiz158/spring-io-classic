package pl.pragmatists

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.ResultActions
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

@ContextConfiguration(classes = GreeterApplication, loader = SpringApplicationContextLoader)
@WebIntegrationTest
class GreeterApplicationIntegrationSpec extends Specification {

    @Autowired
    def WebApplicationContext webApplicationContext

    def "greet provided user"() {
        setup:
        def mvc = webAppContextSetup(webApplicationContext).build()

        when:
        ResultActions result = mvc
            .perform(get("/{who}", "Paul"))
            .andDo(print());

        then:
        result
            .andExpect(status().isOk())
            .andExpect(jsonPath('$.greeting').value('How about hello, Paul ?'))
    }
}
