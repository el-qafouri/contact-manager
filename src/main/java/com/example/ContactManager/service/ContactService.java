package com.example.ContactManager.service;

import com.example.ContactManager.dto.ContactDtoRequest;
import com.example.ContactManager.dto.ContactDtoResponse;
import com.example.ContactManager.mapper.ContactMapper;
import com.example.ContactManager.model.Contact;
import com.example.ContactManager.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepo repo;

    @Autowired
    private ContactMapper mapper;

    public List<ContactDtoResponse> getContacts() {
        List<Contact> contacts = repo.findAll();
        return contacts.stream().map(m -> mapper.toDto(m)).toList();
    }

    public ContactDtoResponse getContact(Long id) {
        Optional<Contact> contact = repo.findById(id);
        return contact.map(m->mapper.toDto(m)).orElse(null);
    }

    public List<ContactDtoResponse> searchByKeyword(String keyword) {
        List<Contact> contacts = repo.findByNameContainingOrPhoneNumberContaining(keyword, keyword);
        return contacts.stream().map(m -> mapper.toDto(m)).toList();
    }

    public Long addContact(ContactDtoRequest request) {
        Contact contact = mapper.toEntity(request);
        return repo.save(contact).getId();
    }


    public boolean deleteContact(Long id) {
        if (repo.findById(id).isEmpty()) {
            return false;
        } else {
            repo.deleteById(id);
            return true;
        }
    }

    public Contact updateContact(Long id, Contact newContact) {
        Contact oldContact = repo.findById(id).orElseThrow();
        oldContact.setName(newContact.getName());
        oldContact.setEmail(newContact.getEmail());
        oldContact.setPhoneNumber(newContact.getPhoneNumber());
        return repo.save(oldContact);
    }

}
