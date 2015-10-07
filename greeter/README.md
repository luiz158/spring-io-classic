greeter
=======

basic setup
-----------

1. `./mvnw clean install`
2. `java -jar target/greeter-0.0.1-SNAPSHOT.jar`

And go to [http://localhost:8080/nkoder]()

docker
------


1. Install Docker: `sudo apt-get install docker.io`.

   Version working with this project: `Docker version 1.5.0, build a8a31ef`
   
2. Build Docker image: `./mvnw clean package`

3. Run it.

   Sample command: `docker run -p 8080:8080 -d --name greeter pragmatists/greeter`

And go to [http://localhost:8080/nkoder]()
 
