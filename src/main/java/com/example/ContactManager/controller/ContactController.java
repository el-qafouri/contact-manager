package com.example.ContactManager.controller;

import com.example.ContactManager.model.Contact;
import com.example.ContactManager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/contacts/{id}")
    public Contact getContact(@PathVariable("id") Long id) {
        return service.getContact(id);
    }

    @GetMapping("/contacts/keyword/{keyword}")
    public List<Contact> searchByKeyword(@PathVariable("keyword") String keyword) {
        return service.searchByKeyword(keyword);
    }

}
