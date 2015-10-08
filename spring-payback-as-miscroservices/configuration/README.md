configuration
=============

Server with configuration for other microservices 

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
