package com.senla.intership.boot.security.dto;

import com.senla.intership.boot.dto.profile.UserProfileDto;
import lombok.Data;

import java.util.List;
@Data
public class UserWithAllDto {
    private Long id;
    private String username;
    private List<RoleDto> roles;
    private UserProfileDto profile;
}
