package com.tds.urlshortener.tdsurlsshortener.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor

@Document(collection = "Url")
public class Url {

    @Id
    private Integer id;
    private String url;
}
