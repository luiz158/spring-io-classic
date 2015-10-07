package pl.pragmatists

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class GreeterApplicationSpec extends Specification {

    MockMvc mvc = standaloneSetup(
        new GreeterApplication(
            greetingTextProperties: new GreetingTextProperties(
                start: 'Whoa!',
                end: 'buddy!'
            )
        )
    ).build()

    def "greet provided user"() {
        when:
        ResultActions result = mvc
            .perform(get("/{who}", "Paul"))
            .andDo(print());
        then:
        result
            .andExpect(status().isOk())
            .andExpect(jsonPath('$.greeting').value('Whoa! Paul buddy!'))
    }
}
