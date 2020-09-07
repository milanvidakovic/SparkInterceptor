# JaxRsInterceptor

This is SparkJava-based Authentication and Authorization framework.

To use it, you need to place following annotations in your code:

* In your application class, add the @Scanner annotation with the top-level package name for annotation scanning.

```java
@Scanner("com.minja")   // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
public class App {
  public App() {
    port(8080);
    get("/rest/student/getall", (Request request, Response response) -> {
      return StudentiService.getAll(request, response);	
	});
    delete("/rest/student/delete/:id", (Request request, Response response) -> {
      return StudentiService.delete(request, response);	
	});
    ...
  }
}
```

* On all REST endpoints where you need Authentication and/or Authorization, add @JwtSecurity annotation:

```java
@JwtSecurity(path = "/rest/student/getall")
public static String getAll(Request request, Response response) {
  response.type("application/json");
  ...
}
```

or:

```java
@JwtSecurity(path = "/rest/student/delete/:id", role = "ROLE_ADMIN")
public static String delete(Request request, Response response) {
  response.type("application/json");
  ...
}
```

* You need to have a field that holds the JWT key. Place @JwtKey annotation above that field:

```java
@JwtKey
public static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
```

* You need to have a class that is used to fetch user using the credentials embedded in the JWT token.
Place @UserProvider annotation above that class and @UserGetter above the method used to obtain a user: 

```java
@UserProvider
public class UserRepo {
  @UserGetter
  public User getUser(String username) {
    ...
  }
}
```

If you want to use Authorization, your User class must contain a filed named *role* which holds roles (usually as enums).

You need to add the CLASSPATH following jars:
* agent.jar
* aspectjweaver-1.9.6.jar
* aspectjrt-1.9.6.jar
* aspectjtools-1.9.6.jar

To start your SparkJava app with the interceptor, add at the end of VM params: 

```
-javaagent:c:\<path-to-aspectj>\aspectjweaver-1.9.6.jar
```

