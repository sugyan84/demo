package com.practice.consumers.news;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.consumers.interf.ResponseDTO;
import com.practice.consumers.interf.ServiceDispatcher;
import com.practice.environment.propertiesConfig.NewsServiceProperties;


@Component
public class NewsServiceDispatcher implements ServiceDispatcher {

    @Autowired
    NewsServiceProperties properties;

    @Override public ResponseDTO makeCall() {

        String response = null;

        Map<String, String> map = new HashMap<>();

        map.put("country", properties.getCountry());
        map.put("category", properties.getCategory());
        map.put("pageSize", String.valueOf(properties.getPageSize()));
        map.put("apiKey", properties.getApiKey());

        response = fireRequest(properties.getBaseURL(), properties.getTopNewsAPI(), map);

        return buildResponse(response);
    }

    @Override public ResponseDTO buildResponse(final String res) {

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseDTO retVal=null;

        try {
             retVal = objectMapper.readValue(res, NewsServiceResponseDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return retVal;
    }
}
