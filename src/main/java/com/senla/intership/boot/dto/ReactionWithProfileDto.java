package com.senla.intership.boot.dto;

import lombok.Data;

@Data
public class ReactionWithProfileDto {
    private Long id;
    private Boolean reaction;
    private UserProfileDto profile;
}
