package com.contactservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.contactservice.Payload.ContactDto;
import com.contactservice.Services.ContactService;

import java.util.List;

@RestController
@RequestMapping("/Contact/")
public class ContactController {
    @Autowired
    private ContactService contactServices;

    @PostMapping("/Add/user:{id}/")
    public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto contactDto, @PathVariable Integer id) {
        ContactDto createContact = this.contactServices.createContact(contactDto, id);
        return new ResponseEntity<>(createContact, HttpStatus.CREATED);
    }

    @GetMapping("/GetContacts/")
    public ResponseEntity<List<ContactDto>> getAllContact() {
        return ResponseEntity.ok(this.contactServices.getAllContact());
    }

    @GetMapping("/GetContact/User:{userId}/")
    public ResponseEntity<List<ContactDto>> getContactByUser(@PathVariable Integer userId) {
        List<ContactDto> contacts = this.contactServices.getContactByUser(userId);
        return new ResponseEntity<List<ContactDto>>(contacts, HttpStatus.OK);
    }

}