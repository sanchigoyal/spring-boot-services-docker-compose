package com.sanchi.java.mailservice.service;

import com.sanchi.java.mailservice.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressDataService {

  @Autowired
  RestTemplate restTemplate;

  @Value("${address.service.base-path}")
  private String addressServiceBasePath;

  public Address getAddress(int memberId) {
    String url = String.format("%s/%s/address", addressServiceBasePath, memberId);
    System.out.println("Fetching address using ---->" + url);
    ResponseEntity<Address> response = restTemplate.getForEntity(url, Address.class);
    return response.getBody();
  }
}
