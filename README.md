# demoblaze-api-testing

Simple api testing framework.  
Tools: Java, RESTAssured, Cucumber, Maven.  

**Dependencies**  
* JDK 8
* Maven   

<h1>How To Run</h1>  

```
mvn test -Dtest=Runner
```    
OR  

```
docker pull dmitryglazov/demoblazeapitesting   
docker run dmitryglazov/demoblazeapitesting
```  

<h1>Configuration</h1>   
Target system address is configurable. You can also run specific tests. Just pass them as an argument like   

```
mvn test -Dtest=Runner -DURI=<target URI> -DCucumber.options="--name 'scenario name here'"
```   
OR   
```
docker run dmitryglazov/demoblazeapitesting -DURI=<target URI> -DCucumber.options="--name 'scenario name here'"
```
