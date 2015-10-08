package commands

import org.crsh.cli.Argument
import org.crsh.cli.Command
import org.crsh.cli.Required
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext
import pl.pragmatists.customer.Customer
import pl.pragmatists.customer.CustomerService

class showCustomer {

    // 1. Open SSH connection to Remote Shell: `ssh -p 2000 user@localhost`
    // 2. Type `help` to see `firstCustomer` on the list
    // 3. Type `firstCustomer first` or `firstCustomer byIndex 0` to use command

    @Usage("Show name of first customer")
    @Command
    def first(InvocationContext context) {
        return byIndex(context, 0)
    }

    @Usage("Show name of customer by index")
    @Command
    def byIndex(InvocationContext context, @Required @Argument Integer index) {
        def customerService = context.attributes['spring.beanfactory'].getBean(CustomerService.class)
        Iterable<Customer> customers = customerService.customers
        return customers.size() > index ? customers[index].firstName : '(not found)'
    }

}
