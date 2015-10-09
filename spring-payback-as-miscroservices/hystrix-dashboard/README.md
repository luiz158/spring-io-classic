merchant microservice
=====================

Project generated with help of [http://start.spring.io/]()

run
---

1. Go to `../configuration` directory and run app according to `README.md`
2. Go to `../registry` directory and run app according to `README.md`
3. Go to `../customer` directory and run app according to `README.md`
4. Go to `../merchant` directory and run app according to `README.md`
5. Go to `../payback` directory and run app according to `README.md`
6. `./mvnw clean package exec:java` in this directory
7. Go to [http://localhost:9090/env]()
8. Go to [http://localhost:9090/hystrix]()
9. In opened Hystrix Dashboard add [http://localhost:9004/hystrix.stream]() to listen to
   (alternatively you may go to [http://localhost:9090/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A9004%2Fhystrix.stream&title=Payback]())

testing
-------

1. Go to dashboard [http://localhost:9090/hystrix]()
2. Play with Hystrix, eg.:
   * do POST to [http://localhost:9004/purchases/123abc/1/150]()
   * kill `customer` microservice
   * do POST to [http://localhost:9004/purchases/123abc/1/150]()
   * run `customer` microservice

