registry
========

Project generated with help of [http://start.spring.io/]()

Uses Eureka from Netflix.

run
---

1. Add to `/etc/hosts`: `127.0.0.1 registry1 registry2`
2. `./mvnw clean package`
3. Run first instance: `java -jar target/registry-0.0.1-SNAPSHOT.jar`
4. Run replica: `java -jar -Dspring.profiles.active=peer2 target/registry-0.0.1-SNAPSHOT.jar`
5. Go to [http://registry1:9009/]()
6. Go to [http://registry2:9010/]()

Sadly, replicas are not seeing each other as available with current configuration :-(
NullPointerException is also OK :-(
