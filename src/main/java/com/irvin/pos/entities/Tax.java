package com.irvin.pos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Tax {
    private long id;
    @Setter
    private String name;
    @Setter
    private long code;
    @Setter
    private int percentage;
}
