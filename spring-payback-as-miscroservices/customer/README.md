customer microservice
=====================

basic run
---------

1. Run `CustomerApplication` from IntelliJ IDEA
2. Go to [http://localhost:8080/customer?creditCard=123abc]()

Actuator endpoints
------------------

* [http://localhost:8080/mappings]()
* [http://localhost:8080/health]()
  You can add more health info by implementing more beans, eg. `DataSourceHealthIndicator`.
  But remember that resulting health info at `/health` is aggregated. 
* [http://localhost:8080/beans]()
* [http://localhost:8080/info]()
  You can add more info by adding `info.something` property
* [http://localhost:8080/env]()
   * env variables
   * active profiles
   * `info` properties from both `classpath:/application.properties` and `classpath:/config/application.properties`
   * specific endpoints for variables, eg. [http://localhost:8080/env/JAVA_HOME]()
* [http://localhost:8080/autoconfig]()
   Info about matching of beans to conditions.
* [http://localhost:8080/trace]()
   * last N requests
   * You can adjust trace info by implementing `TraceRepository`
* [http://localhost:8080/metrics]()
   * You can add more metrics by using `CounterService` or `GaugeService`
   
Remote shell
------------

1. `ssh -p 2000 user@localhost`
2. Password is in startup logs. For example in line `Using default password for shell access: e4476fac-57c8-4777-8b13-07cd5729b1ba`
3. Inside you can run commands similar to Actuator endpoints. And many more.
   * You can show help by typing `help`.
   * Interesting thing is `dashboard`. You can quit dashboard by typing `q` :-P
   * You can use Groovy REPL: `repl groovy` and type `System.exit(1)` :-D
   * In REPL you can also use code from beans, eg. `context.attributes['spring.beanfactory'].getBean('customerService').customers[0].firstName`
   * You can add your own commands by providing them in `resources/commands`. I've provided sample command `firstCustomer.groovy`

