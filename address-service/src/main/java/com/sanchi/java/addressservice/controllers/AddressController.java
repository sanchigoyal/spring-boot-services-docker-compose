package com.sanchi.java.addressservice.controllers;

import com.sanchi.java.addressservice.models.Address;
import com.sanchi.java.addressservice.services.AddressDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

  @Autowired
  private AddressDataService dataService;

  @GetMapping("/{member-id}/address")
  public ResponseEntity<Address> getAddress(@PathVariable("member-id") int memberId) {
    Address address = dataService.getAddress(memberId);
    return ResponseEntity.ok(address);
  }

}
