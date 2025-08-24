package com.example.ContactManager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDtoUpdate {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
}