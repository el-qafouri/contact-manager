package com.example.ContactManager.controller;

import com.example.ContactManager.model.Contact;
import com.example.ContactManager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactService service;

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
    return service.getContacts();
    }

}
