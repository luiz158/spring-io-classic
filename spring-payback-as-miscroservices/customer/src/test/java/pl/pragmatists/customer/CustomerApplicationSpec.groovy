package pl.pragmatists.customer

import groovy.json.JsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.ResultActions
import org.springframework.web.context.WebApplicationContext
import spock.lang.Shared
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

@ContextConfiguration(classes = CustomerApplication, loader = SpringApplicationContextLoader)
@WebIntegrationTest
class CustomerApplicationSpec extends Specification {

    @Autowired
    def WebApplicationContext webApplicationContext

    @Shared
    def mvc

    def setup() {
        mvc = webAppContextSetup(webApplicationContext).build()
    }

    def "find customer by credit card"() {
        when:
        ResultActions result = mvc
            .perform(get("/customer"))
            .andDo(print());

        then:
        result
            .andExpect(status().isOk())
            .andExpect(content().json(
            new JsonBuilder([
                firstName : 'Paweł',
                lastName  : 'Barszcz',
                creditCard: '123abc'
            ]).toString()))
    }
}
