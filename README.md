# Project

Launch with

    mvn clean install spring-boot:run
    
## API description 

### data-access-service

`cd data-access-services && mvn spring-boot:run`

* [GET] /users/

Example results :

`{"firstName": "Toto"}`

* [GET|POST|PUT|DELETE] /users/{id}
* [GET|PUT|DELETE] /users/{id}/adresse

TODO : Mettre l'API sur swagger

### client-management-service 

`cd client-management-service && mvn spring-boot:run`


### client-service 

`cd client-service && mvn spring-boot:run`