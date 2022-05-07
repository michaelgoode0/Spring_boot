package com.senla.intership.boot.dto;

import lombok.Data;

import java.util.List;

@Data
public class PostWithAllDto {
    private Long id;
    private String text;
    private UserProfileWithUserDto profile;
    private List<PostCommentDto> comments;
    private List<ReactionDto> reactions;
}
