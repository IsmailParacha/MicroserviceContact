package com.contactservice.ImplementedServices;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactservice.Entity.Contact;
import com.contactservice.Entity.User;
import com.contactservice.Payload.ContactDto;
import com.contactservice.Repository.ContactRepo;
import com.contactservice.Repository.UserRepo;
import com.contactservice.Services.ContactService;

@Service
public class ContactImplService implements ContactService {

    @Autowired
    private ContactRepo contactRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContactDto createContact(ContactDto contactDto, Integer id) {
        User user = this.userRepo.findById(id).orElse(null);
        Contact contactdata = this.modelMapper.map(contactDto, Contact.class);
        contactdata.setUser(user);
        Contact savedContact = this.contactRepo.save(contactdata);
        return this.modelMapper.map(savedContact, ContactDto.class);

    }

    @Override
    public List<ContactDto> getAllContact() {
        List<Contact> contacts = this.contactRepo.findAll();
        List<ContactDto> showData = contacts.stream().map(contact -> this.modelMapper.map(contact, ContactDto.class))
                .collect(Collectors.toList());

        return showData;
    }

    @Override
    public List<ContactDto> getContactByUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(null);
        List<Contact> contacts = this.contactRepo.findByUser(user);
        List<ContactDto> contactDtos = contacts.stream().map(contact -> this.modelMapper.map(contact, ContactDto.class))
                .collect(Collectors.toList());
        return contactDtos;
    }

}
