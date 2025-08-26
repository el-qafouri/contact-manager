package com.example.ContactManager.controller;

import com.example.ContactManager.dto.ContactDtoRequest;
import com.example.ContactManager.dto.ContactDtoResponse;
import com.example.ContactManager.dto.ContactDtoUpdate;
import com.example.ContactManager.model.Contact;
import com.example.ContactManager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ContactController {
    @Autowired
    private ContactService service;

    @GetMapping("/contacts")
    public List<ContactDtoResponse> getContacts() {
        return service.getContacts();
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<?> getContact(@PathVariable("id") Long id) {
        try {
            ContactDtoResponse contact = service.getContact(id);
            return ResponseEntity.ok(contact);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/contacts/keyword/{keyword}")
    public List<ContactDtoResponse> searchByKeyword(@PathVariable("keyword") String keyword) {
        return service.searchByKeyword(keyword);
    }

    @PostMapping("/contacts")
    public ResponseEntity<ContactDtoResponse> addContact(@RequestBody ContactDtoRequest contact) {
        try {
            ContactDtoResponse saved = service.addContact(contact);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        try {
            service.deleteContact(id);
            return ResponseEntity.ok("contact was deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity<?> updateContact(@PathVariable Long id, @RequestBody ContactDtoUpdate request) {
        try {
            request.setId(id);
            Contact updateContact = service.updateContact(request);
            return ResponseEntity.ok(updateContact);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
