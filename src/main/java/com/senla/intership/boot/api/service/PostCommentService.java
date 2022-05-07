package com.senla.intership.boot.api.service;

import com.senla.intership.boot.dto.PostCommentWithAllDto;
import com.senla.intership.boot.dto.PostCommentWithPostDto;

public interface PostCommentService {
    PostCommentWithPostDto create(PostCommentWithPostDto commentDto);

    PostCommentWithPostDto update(PostCommentWithPostDto commentDto);

    void delete(Long id);

    PostCommentWithAllDto read(Long id);
}
