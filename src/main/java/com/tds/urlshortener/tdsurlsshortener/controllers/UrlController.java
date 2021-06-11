package com.tds.urlshortener.tdsurlsshortener.controllers;

import com.tds.urlshortener.tdsurlsshortener.model.Url;
import com.tds.urlshortener.tdsurlsshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/urlshorteners")
public class UrlController {

    @Autowired
    private UrlRepository repository;

    @PostMapping
    public Url saveUrl(@RequestBody Url url){
        return repository.save(url);
    }

    @GetMapping
    public List<Url> getUrls(){
        return repository.findAll();
    }
}
