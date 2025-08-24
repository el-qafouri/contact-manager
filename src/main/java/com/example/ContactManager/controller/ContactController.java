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

@RestController
public class ContactController {
    @Autowired
    private ContactService service;

    @GetMapping("/contacts")
    public List<ContactDtoResponse> getContacts() {
        return service.getContacts();
    }

    @GetMapping("/contacts/{id}")
    public ContactDtoResponse getContact(@PathVariable("id") Long id) {
        return service.getContact(id);
    }

    @GetMapping("/contacts/keyword/{keyword}")
    public List<ContactDtoResponse> searchByKeyword(@PathVariable("keyword") String keyword) {
        return service.searchByKeyword(keyword);
    }

    @PostMapping("/contacts")
    public String addContact(@RequestBody ContactDtoRequest contact) {
        Long savedId = service.addContact(contact);
        return "saved with id:   " +   savedId;
    }


    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        try {
            boolean deleted = service.deleteContact(id);
            if (deleted) {
                return ResponseEntity.ok("contact was deleted");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("contact not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("occurred error");
        }
    }

    @PutMapping("/contacts/{id}")
    public String updateContact(@PathVariable Long id, @RequestBody ContactDtoUpdate request) {
        request.setId(id);
        service.updateContact(request);
       return "updated successfully...";
    }
}
