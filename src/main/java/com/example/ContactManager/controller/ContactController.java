package com.example.ContactManager.controller;

import com.example.ContactManager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @Autowired
    private ContactService service;

}
