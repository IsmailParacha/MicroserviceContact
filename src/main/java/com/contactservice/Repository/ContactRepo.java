package com.contactservice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contactservice.Entity.Contact;
import com.contactservice.Entity.User;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
    List<Contact> findByUser(User user);
}
