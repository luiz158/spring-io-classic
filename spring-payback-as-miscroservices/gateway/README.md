gateway
=======

Project generated with help of [http://start.spring.io/]()

run
---

1. Go to `../authserver` directory and run app according to `README.md`
2. Go to `../configuration` directory and run app according to `README.md`
3. Go to `../registry` directory and run app according to `README.md`
4. Go to `../customer` directory and run app according to `README.md`
5. Go to `../merchant` directory and run app according to `README.md`
6. Go to `../payback` directory and run app according to `README.md`
7. `./mvnw clean package exec:java` in this directory
8. Go to [http://localhost:9999/env]()
9. See mappings at [http://localhost:9999/mappings]()
10. Access `merchant`'s endpoints, eg. [http://localhost:9999/merchant/merchants/1]()
11. Access `customer`'s endpoints, eg. [http://localhost:9999/customer/customers?creditCard=abc123]()
12. Access `paybacks`'s endpoints, eg:
    * POST on [http://localhost:9999/payback/purchases/123abc/1/150]()
    * GET on [http://localhost:9999/payback/paybacks]()
13. Go to Dashboard [http://localhost:9090/hystrix]() and try monitoring of [http://localhost:9999/hystrix.stream]().
    Or go directly to [http://localhost:9090/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A9999%2Fhystrix.stream&title=Gateway]() )
    Then watch changes in metrics when accessing `gateway`'s endpoints. 
    
Credentials are:
* `user`/`password` for user OAuth2 authorization (nice HTML form in browser)
* `user`/`<password from gateway logs>` for BasicAuth popup (eg. when accessing [http://localhost:9999/mappings]())
