package com.example.ContactManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDtoResponse {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
}