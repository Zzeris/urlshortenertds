package com.tds.urlshortener.tdsurlsshortener.ControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tds.urlshortener.tdsurlsshortener.controllers.UrlController;
import com.tds.urlshortener.tdsurlsshortener.model.Url;
import com.tds.urlshortener.tdsurlsshortener.repository.UrlRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(UrlController.class)
public class UrlControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UrlRepository urlRepository;

    @Test
    public void testListUrls() throws Exception{
        List<Url> listUrls = new ArrayList<>();

        listUrls.add(new Url("xxx"));
        listUrls.add(new Url("yyy"));
        listUrls.add(new Url("zzz"));

        Mockito.when(urlRepository.findAll()).thenReturn(listUrls);

        String req = "/urlshorteners";

        mockMvc.perform(MockMvcRequestBuilders.get(req)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddUrl() throws Exception{
        Url newUrl = new Url("xxx");
        Url addUrl = new Url("xxx");

        Mockito.when(urlRepository.save(newUrl)).thenReturn(addUrl);

        String req = "/urlshorteners";

        mockMvc.perform(MockMvcRequestBuilders.post(req).contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("xxx"));
    }
}
