authserver
==========

This project is copy of [https://github.com/spring-cloud-samples/authserver]()

run
---

1. `./mvnw clean package exec:java`
2. Test authorization manually:
   * Go to [http://localhost:8080/uaa/oauth/authorize?client_id=acme&redirect_uri=http://127.0.1.1:9999/login&response_type=code]()
     `http://127.0.1.1:9999/login` needs to point to any of working services ()just something up and running), so I;ve put URL of Gateway here
   * Sample user and password are `user`/`password`. Type them, submit, then click `Approve`.
   * Copy code from new URL which appears in browser. Eg. `5zsc0t` if URL is [http://127.0.1.1:9999/login?code=5zsc0t]()
     Code is valid for one usage (to obtain authoriation token).
   * Make request with CURL to obtain access token. Code should be appropriate. Redirect URI should be same as before.
     `curl acme:acmesecret@localhost:8080/uaa/oauth/token -d grant_type=authorization_code -d redirect_uri=http://127.0.1.1:9999/login -d code=hSfP9X`
   * Go to [http://jwt.io/]() and:
       * paste access token
       * paste public key of our sample authorization server:
          ```
          -----BEGIN PUBLIC KEY-----
          MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnGp/Q5lh0P8nPL21oMMrt2RrkT9AW5jgYwLfSUnJVc9G6uR3cXRRDCjHqWU5WYwivcF180A6CWp/ireQFFBNowgc5XaA0kPpzEtgsA5YsNX7iSnUibB004iBTfU9hZ2Rbsc8cWqynT0RyN4TP1RYVSeVKvMQk4GT1r7JCEC+TNu1ELmbNwMQyzKjsfBXyIOCFU/E94ktvsTZUHF4Oq44DBylCDsS1k7/sfZC2G5EU7Oz0mhG8+Uz6MSEQHtoIi6mc8u64Rwi3Z3tscuWG2ShtsUFuNSAFNkY7LkLn+/hxLCu2bNISMaESa8dG22CIMuIeRLVcAmEWEWH5EEforTg+QIDAQAB
          -----END PUBLIC KEY-----
          ```
       * you should see `Signature Verified` summary

Original README
---------------

This project is a simple, minimal implementation of an OAuth2
Authorization Server for use with Spring Cloud sample apps. It has a
context root of `/uaa` (so that it won't share cookies with other apps
running on other ports on the root resource). OAuth2 endpoints are:

* `/uaa/oauth/token` the Token endpoint, for clients to acquire access
  tokens. There is one client ("acme" with secret "acmesecret"). With
  Spring Cloud Security this is the `oauth2.client.tokenUri`.
* `/uaa/oauth/authorize` the Authorization endpoint to obtain user
  approval for a token grant.  Spring Cloud Security configures this
  in a client app as `oauth2.client.authorizationUri`.
* `/uaa/oauth/check_token` the Check Token endpoint (not part of the
  OAuth2 spec). Can be used to decode a token remotely. Spring Cloud
  Security configures this in a client app as
  `oauth2.resource.tokenInfoUri`.
