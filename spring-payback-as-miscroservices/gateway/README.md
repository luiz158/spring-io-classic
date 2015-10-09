gateway
=======

Project generated with help of [http://start.spring.io/]()

run
---

1. Go to `../configuration` directory and run app according to `README.md`
2. Go to `../registry` directory and run app according to `README.md`
3. Go to `../customer` directory and run app according to `README.md`
4. Go to `../merchant` directory and run app according to `README.md`
5. Go to `../payback` directory and run app according to `README.md`
6. `./mvnw clean package exec:java` in this directory
7. Go to [http://localhost:9999/env]()
8. See mappings at [http://localhost:9999/mappings]()
9. Access `merchant`'s endpoints, eg. [http://localhost:9999/merchant/merchants/1]()
10. Access `customer`'s endpoints, eg. [http://localhost:9999/customer/customers?creditCard=abc123]()
11. Access `paybacks`'s endpoints, eg:
    * POST on [http://localhost:9999/payback/purchases/123abc/1/150]()
    * GET on [http://localhost:9999/payback/paybacks]()
12. Go to Dashboard [http://localhost:9090/hystrix]() and try monitoring of [http://localhost:9999/hystrix.stream]().
    Or go directly to [http://localhost:9090/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A9999%2Fhystrix.stream&title=Gateway]() )
    Then watch changes in metrics when accessing `gateway`'s endpoints. 
    
