package com.contactservice.Services;

import java.util.List;

import com.contactservice.Payload.ContactDto;

public interface ContactService {
    ContactDto createContact(ContactDto contactDto, Integer userId);

    List<ContactDto> getAllContact();

    List<ContactDto> getContactByUser(Integer userId);
}
