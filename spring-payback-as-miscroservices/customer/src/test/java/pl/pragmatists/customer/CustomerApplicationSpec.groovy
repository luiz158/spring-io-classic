package pl.pragmatists.customer

import groovy.json.JsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.ResultActions
import org.springframework.web.context.WebApplicationContext
import spock.lang.Ignore
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

    def "find no customer if credit card is not provided"() {
        when:
        ResultActions result = mvc
            .perform(get("/customer"))
            .andDo(print());

        then:
        result
            .andExpect(status().isBadRequest())
            .andExpect(status().reason("No credit card provided"))
    }

    def "find no customer by credit card if no such user exist"() {
        when:
        ResultActions result = mvc
            .perform(get("/customer?creditCard=notExistingCreditCard"))
            .andDo(print());

        then:
        result
            .andExpect(status().isNotFound())
            .andExpect(status().reason("No user found with credit card 'notExistingCreditCard'"))
    }

    @Ignore
    def "find customer by credit card"() {
        when:
        def creditCard = "123abc"
        ResultActions result = mvc
            .perform(get("/customer?creditCard={creditCard}", creditCard))
            .andDo(print());

        then:
        // TODO Dummy data is provided here. To be replaced with insertion to 'database'.
        result
            .andExpect(status().isOk())
            .andExpect(content().json(
            new JsonBuilder([
                firstName : 'Paweł',
                lastName  : 'Barszcz',
                creditCard: creditCard
            ]).toString()))
    }
}
