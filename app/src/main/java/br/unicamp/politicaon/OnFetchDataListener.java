package br.unicamp.politicaon;

import br.unicamp.politicaon.Models.NewsHeadLines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {

    void onFetchData(List<NewsHeadLines> list, String message);
    void onError(String message);


}
