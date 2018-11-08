package com.practice.consumers.news;

import com.practice.consumers.interf.ResponseDTO;


public class NewsServiceResponseDTO implements ResponseDTO {

    String status;
    int totalResults;

    Article[] articles;

    public NewsServiceResponseDTO() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(final int totalResults) {
        this.totalResults = totalResults;
    }

    public Article[] getArticles() {
        return articles;
    }

    public void setArticles(final Article[] articles) {
        this.articles = articles;
    }
}
