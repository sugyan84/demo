package com.practice.environment.propertiesConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "service.news")
public class NewsServiceProperties {

    String baseURL;
    String topNewsAPI;
    String country;
    String category;
    int pageSize;
    String apiKey;

    public NewsServiceProperties() {
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(final String baseURL) {
        this.baseURL = baseURL;
    }

    public String getTopNewsAPI() {
        return topNewsAPI;
    }

    public void setTopNewsAPI(final String topNewsAPI) {
        this.topNewsAPI = topNewsAPI;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(final String apiKey) {
        this.apiKey = apiKey;
    }
}
