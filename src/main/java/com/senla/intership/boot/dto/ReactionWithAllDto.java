package com.senla.intership.boot.dto;

import lombok.Data;

@Data
public class ReactionWithAllDto {
    private Long id;
    private Boolean reaction;
    private UserProfileDto profile;
    private PostDto post;
}
