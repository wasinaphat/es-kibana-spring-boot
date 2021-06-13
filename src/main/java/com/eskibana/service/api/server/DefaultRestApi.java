package com.eskibana.service.api.server;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

@RestController
@RequestMapping(value = "/api")
public class DefaultRestApi {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultRestApi.class);

    @GetMapping(value = "/welcome")
    public String welcome(){
        return "welcome to spring boot";
    }

    @GetMapping(value = "/time")
    public String testTime(){
        return LocalTime.now().toString();
    }

    @GetMapping(value = "/header-one")
    public String headerByAnnotation(@RequestHeader(name = "User-agent") String headerUserAgent ,@RequestHeader(name = "Practical-java") String headerPracticeJava){
        return "User-agent : " + headerUserAgent + ", Practical-java  : " + headerPracticeJava;
    }

    @GetMapping(value = "/header-two")
    public String headerByRequest(ServerHttpRequest request){

        return "User-agent :" + request.getHeaders().getValuesAsList("User-agent") + " , Practical-java :"
                + request.getHeaders().getValuesAsList("Practical-java");
    }

    @GetMapping(value = "/random-error")
    public ResponseEntity<String> randomError(){
        int remainder = new Random().nextInt()%5;
        var body = "Kibana";

        switch (remainder){
            case 0:
                return ResponseEntity.ok().body(body);
            case 1:
            case 2:
                return ResponseEntity.badRequest().body(body);
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

}
