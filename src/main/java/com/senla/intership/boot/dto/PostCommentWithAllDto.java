package com.senla.intership.boot.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PostCommentWithAllDto {
    private Long id;
    @NotEmpty(message = "Post comment can not be empty")
    private String text;
    private UserProfileWithUserDto profile;
    private PostDto post;
}
