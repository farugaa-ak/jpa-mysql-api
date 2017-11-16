package com.akademiakodu.thymeleaf.json;

import com.akademiakodu.thymeleaf.model.Article;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonCreatorTemporary {


    public static void main(String[] args) {
        Article article = new Article("title", "connnn", "ttttags");

        String json = convertToJson(article);
        System.out.println(json);
    }

    private static String convertToJson(Article article) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(article);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
