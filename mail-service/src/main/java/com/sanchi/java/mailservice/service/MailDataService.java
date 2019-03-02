package com.sanchi.java.mailservice.service;

import com.sanchi.java.mailservice.models.Mail;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class MailDataService {

  private Map<Integer, List<Mail>> mailMap = new HashMap<>();

  public void postMail(int memberId, Mail mail) {
    mailMap.putIfAbsent(memberId, new ArrayList<>());
    mailMap.get(memberId).add(mail);
  }

  public List<Mail> getMails(int memberId) {
    return mailMap.get(memberId);
  }
}
