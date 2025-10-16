package com.kaarel.foodplanner.dtos;

import com.kaarel.foodplanner.models.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserRegistrationDTO {

    private String username;
    private String password;
    private Set<Role> roles;
}
