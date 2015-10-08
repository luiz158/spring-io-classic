registry
========

Project generated with help of [http://start.spring.io/]()

Uses Eureka from Netflix.

1. `./mvnw clean package`
2. Run first instance: `java -jar target/registry-0.0.1-SNAPSHOT.jar`
4. Run replica: `java -jar -Dspring.profiles.active=peer2 target/registry-0.0.1-SNAPSHOT.jar`
5. Go to [http://localhost:9009/]()
6. Go to [http://localhost:9010/]()
