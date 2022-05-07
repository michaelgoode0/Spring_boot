package com.senla.intership.boot.dto;


import lombok.Data;

@Data
public class PostWithProfileDto {
    private Long id;
    private String text;
    private UserProfileWithAllDto userProfile;
}
