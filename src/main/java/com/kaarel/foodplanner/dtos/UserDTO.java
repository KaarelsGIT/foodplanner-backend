package com.kaarel.foodplanner.dtos;

import com.kaarel.foodplanner.models.Role;
import lombok.*;

import java.util.Set;

@Data
@Builder
public class UserDTO {

    private Long id;
    private String username;
    private Set<Role> roles;
}
