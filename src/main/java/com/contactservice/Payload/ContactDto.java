package com.contactservice.Payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ContactDto {
    private int cId;
    private String email;
    private String contactName;
}
