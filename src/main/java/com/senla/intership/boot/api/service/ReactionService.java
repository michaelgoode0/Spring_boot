package com.senla.intership.boot.api.service;

import com.senla.intership.boot.dto.PostDto;
import com.senla.intership.boot.dto.ReactionDto;
import com.senla.intership.boot.dto.ReactionWithProfileDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReactionService {
   void react(PostDto postDto, boolean reaction);
   List<ReactionDto> getAll();
   Page<ReactionWithProfileDto> findAllByPost(Pageable pageable, Long id);
}
