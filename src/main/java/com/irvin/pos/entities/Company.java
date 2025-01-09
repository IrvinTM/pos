package com.irvin.pos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Company {
    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String logo;
}
