configuration
=============

Server with configuration for other microservices.
 
* Properties are stored in `config-repository` directory.
* Configuration server is served on port `9001`
* Customer microservice is served on port `9002`

Normally we will use `spring.cloud.config.server.git.uri` as properties pointing to Git repo with configuration.
For the purpose of simplicity I use instead:
* `spring.cloud.config.server.native.search-locations` pointing to directory in filesystem (without Git repo)
* `spring.profiles.active=native`

You can see available properties (may contain duplicates) at:
* [http://localhost:9001/customer/default/master]()
* [http://localhost:9001/customer/profile1/master]()
* [http://localhost:9001/customer/profile2/master]()

You can fetch resolved final properties at:
* [http://localhost:9001/customer-default.yml]()
* [http://localhost:9001/customer-profile1.yml]()
* [http://localhost:9001/customer-profile2.yml]()

In link above both `yml` and `properties` extensions are recognized and output is formatted properly.

To see that `customer` microservices has found remote configuration
 go to [http://localhost:9002/info]() to see properties provided
 by configuration.

You can also change properties in (for example in `customer.yml`):
1. Change for example `info.some.property.visible.everywhere`
2. Change `customerProps.firstNameSuffix`
3. Do `POST` on [http://localhost:9002/refresh]()
4. Open [http://localhost:9002/env]() and look into `configService:(...)` section to see actual values of properties
5. Open [http://localhost:9002/customer?creditCard=123abc]() and see changed first name of customer

`customerProps.firstNameSuffix` is refreshed in `CustomerController` thanks
 to `CustomerProperties` (which has `@ConfigurationProperties` annotation).
