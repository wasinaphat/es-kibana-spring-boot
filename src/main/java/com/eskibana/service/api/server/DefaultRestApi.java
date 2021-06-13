package com.eskibana.service.api.server;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class DefaultRestApi {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultRestApi.class);

    @GetMapping(value = "/header-one")
    public String headerByAnnotation(@RequestHeader(name = "User-agent") String headerUserAgent ,@RequestHeader(name = "Practical-java") String headerPracticeJava){
        return "User-agent : " + headerUserAgent + ", Practical-java  : " + headerPracticeJava;
    }

    @GetMapping(value = "/header-two")
    public String headerByRequest(ServerHttpRequest request){
        return "User-agent :" + request.getHeaders().getValuesAsList("User-agent") + " , Practical-java :"
                + request.getHeaders().getValuesAsList("Practical-java");
    }

}
