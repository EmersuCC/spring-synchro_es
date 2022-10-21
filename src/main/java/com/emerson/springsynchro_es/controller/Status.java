package com.emerson.springsynchro_es.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class Status {
    
    @GetMapping
    public String status() throws UnknownHostException{
        return "This app is running " + Instant.now() + " on server: " + InetAddress.getLocalHost() + " ";
    }
}
