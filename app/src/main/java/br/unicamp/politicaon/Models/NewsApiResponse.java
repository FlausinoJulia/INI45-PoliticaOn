package br.unicamp.politicaon.Models;

import java.io.Serializable;
import java.util.List;

public class NewsApiResponse implements Serializable {

    String status;
    int totalResults;
    List<NewsHeadLines> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsHeadLines> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsHeadLines> articles) {
        this.articles = articles;
    }

}
