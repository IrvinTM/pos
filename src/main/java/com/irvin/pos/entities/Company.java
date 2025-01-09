package com.irvin.pos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private long id;
    @Setter private String name;
    @Setter private String address;
    @Setter private String phoneNumber;
    @Setter private String email;
    @Setter private String logo;
}
