package com.contactservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contactservice.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
