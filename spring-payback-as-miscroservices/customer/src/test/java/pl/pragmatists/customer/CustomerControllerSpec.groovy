package pl.pragmatists.customer

import groovy.json.JsonBuilder
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class CustomerControllerSpec extends Specification {

    MockMvc mvc = standaloneSetup(new CustomerController()).build()

    def "find customer by credit card"() {
        when:
        ResultActions result = mvc
            .perform(get("/customer"))
            .andDo(print());
        then:
        result
            .andExpect(status().isOk())
            .andExpect(content().json(new JsonBuilder([abc: 'sdsds']).toString()))
    }
}
