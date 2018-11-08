package com.practice.consumers.interf;

import java.util.Map;
import org.springframework.web.client.RestTemplate;


public interface ServiceDispatcher {

    public ResponseDTO makeCall();

    default String fireRequest(String baseURL, String apiPath, Map<String, String> queryParams){
        StringBuffer uri = new StringBuffer();

        uri.append(baseURL);
        uri.append(apiPath);

        if(queryParams!=null && queryParams.size()>0){
            uri.append("?");
        }

        queryParams.entrySet().stream().forEach(entry -> {
            String key = entry.getKey();
            String val = entry.getValue();
            uri.append(key).append("=").append(val).append("&");
        });

        uri.deleteCharAt(uri.length()-1);

        System.out.println("Firing request for URI: |"+uri+"|");

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri.toString(), String.class);

        return result;
    }

    public ResponseDTO buildResponse(String res);
}
