package com.miempresa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

    @GetMapping("/pricing")
    public ResponseEntity<String> getPricing(@RequestHeader("X-Auth-Token") String authToken) {
        String url = "https://bss.myhuaweicloud.com/v1/pricing/calculator";
        
        RestTemplate restTemplate = new RestTemplate();
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("X-Auth-Token", authToken);
        
        org.springframework.http.HttpEntity<String> entity = new org.springframework.http.HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, org.springframework.http.HttpMethod.GET, entity, String.class);
        
        return ResponseEntity.ok(response.getBody());
    }
}
