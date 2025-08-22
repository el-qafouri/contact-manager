package com.example.ContactManager.service;

import com.example.ContactManager.model.Contact;
import com.example.ContactManager.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepo repo;

    public List<Contact> getContacts() {
        return repo.findAll();
    }

    public Contact getContact(Long id) {
        return repo.findById(id).orElse(new Contact());
    }

    public List<Contact> searchByKeyword(String keyword) {
        return repo.findByNameContainingOrPhoneNumberContaining(keyword, keyword);
    }

    public Contact addContact(Contact contact) {
        return repo.save(contact);
    }


//    public boolean deleteContact(Long id) {
//        if (repo.existsById(id)) {
//            repo.deleteById(id);
//            return true;
//        }
//        return false;
//    }


    public boolean deleteContact(Long id) {
        if (repo.findById(id).isEmpty()) {
            return false;
        } else {
            repo.deleteById(id);
            return true;
        }
    }
}
