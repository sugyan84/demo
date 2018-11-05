package com.practice.consumers.stockPrice;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StockPriceConsumer {

    @Value("${consumer.stockprice.user.key}")
    private String userKey;

    public String getEmployees() {
        final String uri = "http://gturnquist-quoters.cfapps.io/api/random";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return "Result is\n" + result;
    }

    public String getTimeSeriesDailyStockPrices(String function, String symbol, String interval) {

        final String baseURL = "https://www.alphavantage.co/";

        //query?function=TIME_SERIES_INTRADAY&symbol=MSFT&interval=5min&apikey=demo";

        StringBuffer urlBuilder = new StringBuffer(baseURL)
                .append("query?function=").append(function)
                .append("&symbol=").append(symbol)
                .append("&interval=").append(interval)
                .append("&apikey=").append(userKey);

        RestTemplate template = new RestTemplate();
        String response = template.getForObject(urlBuilder.toString(), String.class);

        return response;
    }
}
