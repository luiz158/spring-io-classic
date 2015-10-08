merchant microservice
=====================

Project generated with help of [http://start.spring.io/]()

Port was `8080` by default but after adding remote configuration
 it is provided by that configuration.
 In result port is `9004`.

run
---

1. Go to `../configuration` directory and run app according to `README.md`
2. Go to `../registry` directory and run app according to `README.md`
3. `./mvnw clean package exec:java` in this directory
4. Go to [http://registry1:9009/]() and check that `payback` is registered.
5. Go to [http://localhost:9004/env]()
6. Go to [http://localhost:9004/paybacks]()
7. Go to [http://localhost:9004/discover/homepage/config]() (or '/merchant' or '/customer')
