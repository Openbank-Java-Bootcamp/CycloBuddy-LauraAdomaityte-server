package com.ironhack.cyclobuddyserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVerifyDTO {
    private String name;
    private Integer id;

    public UserVerifyDTO(String name) {
        this.name = name;
    }

    public UserVerifyDTO(Integer id) {
        this.id = id;
    }
}
