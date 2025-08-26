package com.example.ContactManager.service;

import com.example.ContactManager.dto.ContactDtoRequest;
import com.example.ContactManager.dto.ContactDtoResponse;
import com.example.ContactManager.dto.ContactDtoUpdate;
import com.example.ContactManager.mapper.ContactMapper;
import com.example.ContactManager.model.Contact;
import com.example.ContactManager.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepo repo;

    @Autowired
    private ContactMapper mapper;

    public List<ContactDtoResponse> getContacts() {
        List<Contact> contacts = repo.findAll();
        return contacts
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public ContactDtoResponse getContact(Long id) {
        Optional<Contact> contact = repo.findById(id);
        return contact.map(mapper::toDto)
                .orElseThrow(() -> new NoSuchElementException("not found this contact: " + id));
    }

    public List<ContactDtoResponse> searchByKeyword(String keyword) {
        List<Contact> contacts = repo.findByNameContainingOrPhoneNumberContaining(keyword, keyword);
        return contacts
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public ContactDtoResponse addContact(ContactDtoRequest request) {
        Contact contact = mapper.toEntity(request);
        Contact savedContact = repo.save(contact);
        return mapper.toDto(savedContact);
    }

    public void deleteContact(Long id) {
        Contact contact = repo.findById(id).orElseThrow(()
                -> new RuntimeException("not found this: " + id));
        repo.delete(contact);
    }

    public Contact updateContact(ContactDtoUpdate request) {
        Contact existContact = repo
                .findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Contact not found contact with id: " + request.getId()));
        existContact.setName(request.getName());
        existContact.setEmail(request.getEmail());
        existContact.setPhoneNumber(request.getPhoneNumber());
        return repo.save(existContact);
    }

}
