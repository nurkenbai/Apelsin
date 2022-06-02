package com.company.service.integration;

import com.company.dto.response.CardResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UzCardService {
    @Value("${uzcard.url}")
    private String url;
    @Value("${uzcard.username}")
    private String username;
    @Value("${uzcard.password}")
    private String password;

    public CardResponseDTO getCard(String cardNumber) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://167.172.66.39:9091/v1/card/getByCardNumber/" + cardNumber;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth("bank", "bankjon");

        HttpEntity httpEntity = new HttpEntity(headers);

        ResponseEntity<CardResponseDTO> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, CardResponseDTO.class);
        return response.getBody();
    }
}
