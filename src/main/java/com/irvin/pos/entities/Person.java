package com.irvin.pos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private long id;
    @Setter private String name;
    @Setter private Rol rol;
    @Setter private String identification;
    @Setter private String address;
    @Setter private String phoneNumber;
    @Setter private String email;
}
