package com.stark.springbootcircuitbreaker.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class SpringBootServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "reliable",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
    public String getMessage() throws InterruptedException {
//        Thread.sleep(2000); // This could be added to below /v1/api to validate the timeout condition mentioned above.

        URI uri = URI.create("http://localhost:8081/v1/api");

        return restTemplate.getForObject(uri, String.class);
    }

    public String reliable() {
        return "Hello from Default World !!";
    }

}
