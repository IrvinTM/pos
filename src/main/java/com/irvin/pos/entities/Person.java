package com.irvin.pos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person {
    private long id;
    private String name;
    private Rol rol;
    private String identification;
    private String address;
    private String phoneNumber;
    private String email;
}
