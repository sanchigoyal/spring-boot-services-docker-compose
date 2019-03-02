package com.sanchi.java.mailservice.controllers;

import com.sanchi.java.mailservice.models.Address;
import com.sanchi.java.mailservice.models.Mail;
import com.sanchi.java.mailservice.service.AddressDataService;
import com.sanchi.java.mailservice.service.MailDataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

  @Autowired
  private MailDataService mailDataService;

  @Autowired
  private AddressDataService addressDataService;

  @PostMapping("/{member-id}/mails")
  public ResponseEntity sendMail(@PathVariable("member-id") int memberId, @RequestBody Mail mail) {

    Address memberAddress = addressDataService.getAddress(memberId);
    mail.setAddress(memberAddress);
    mailDataService.postMail(memberId, mail);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{member-id}/mails")
  public ResponseEntity<List<Mail>> getMails(@PathVariable("member-id") int memberId) {
    List<Mail> mails = mailDataService.getMails(memberId);
    return ResponseEntity.ok(mails);
  }

}
