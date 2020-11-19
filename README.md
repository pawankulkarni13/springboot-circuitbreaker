# springboot-circuitbreaker


This Application demonstrates Circuit Breaker pattern while calling other microservice.

This Adds to the fault tolerance of other App failures.

I've used springboot-rest as another application to run with this app.

This App also contains a Hystrix Dashboard. Accessible through http://localhost:8080/hystrix/

Also the Hystrix Stream: http://localhost:8080/actuator/hystrix.stream

You can also add Thread.sleep to check the timeout conditions on the rest calls.
Thread.sleep(2000);
