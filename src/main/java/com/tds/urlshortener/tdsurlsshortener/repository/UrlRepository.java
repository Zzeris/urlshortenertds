package com.tds.urlshortener.tdsurlsshortener.repository;

import com.tds.urlshortener.tdsurlsshortener.model.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<Url, String> {
}
