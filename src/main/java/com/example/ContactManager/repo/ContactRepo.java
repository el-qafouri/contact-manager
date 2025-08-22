package com.example.ContactManager.repo;

import com.example.ContactManager.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {

    List<Contact> findByNameContainingOrPhoneNumberContaining(String name, String phoneNumber);

}
