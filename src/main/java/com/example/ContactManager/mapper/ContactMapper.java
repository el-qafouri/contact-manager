package com.example.ContactManager.mapper;

import com.example.ContactManager.dto.ContactDtoRequest;
import com.example.ContactManager.dto.ContactDtoResponse;
import com.example.ContactManager.model.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {
    public Contact toEntity(ContactDtoRequest request) {
        return Contact.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    public ContactDtoResponse toDto(Contact contact) {
        return new ContactDtoResponse(
                contact.getId(),
                contact.getName(),
                contact.getEmail(),
                contact.getPhoneNumber()
        );
    }
}
