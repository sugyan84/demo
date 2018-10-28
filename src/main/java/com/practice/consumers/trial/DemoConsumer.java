package com.practice.consumers.trial;

import org.springframework.web.client.RestTemplate;


public class DemoConsumer {

    public String getEmployees() {
        final String uri = "http://gturnquist-quoters.cfapps.io/api/random";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return "Result is\n" + result;
    }
}
