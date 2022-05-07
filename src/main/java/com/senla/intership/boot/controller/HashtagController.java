package com.senla.intership.boot.controller;

import com.senla.intership.boot.api.service.HashtagService;
import com.senla.intership.boot.dto.HashtagWithPostsDto;
import com.senla.intership.boot.util.AuthNameHolder;
import com.senla.intership.boot.util.SortHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/hashtags")
public class HashtagController {

    private final HashtagService hashtagService;

    @GetMapping
    public ResponseEntity<List<HashtagWithPostsDto>> getAll(@RequestParam(required = false, defaultValue = "id") String sort,
                                                            @RequestParam(required = false, defaultValue = "0") Integer page,
                                                            @RequestParam(required = false, defaultValue = "asc")String direction,
                                                            @RequestParam(required = false, defaultValue = "10")Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.by(SortHelper.orderDirection(direction),sort));
        Page<HashtagWithPostsDto> result = hashtagService.getAll(pageable);
        log.info("The user, " + AuthNameHolder.getAuthUsername() + ", got a list of all hashtags");
        return ResponseEntity.ok(result.getContent());
    }
    @GetMapping("/top")
    public ResponseEntity<List<HashtagWithPostsDto>> findTopHashtags(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                                     @RequestParam(required = false, defaultValue = "5")Integer size){
        Pageable pageable = PageRequest.of(page, size,Sort.by("id"));
        Page<HashtagWithPostsDto> result = hashtagService.getAllTop(pageable);
        log.info("The user, " + AuthNameHolder.getAuthUsername() + ", got a list of top hashtags ");
        return ResponseEntity.ok(result.getContent());
    }
}
