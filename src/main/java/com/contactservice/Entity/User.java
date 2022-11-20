package com.contactservice.Entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phoneNo;
    // private Set<ContactDto> contact = new HashSet<>();

}