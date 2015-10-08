customer microservice
=====================

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
   

