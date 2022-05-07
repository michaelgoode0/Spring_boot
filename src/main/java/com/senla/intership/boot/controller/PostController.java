package com.senla.intership.boot.controller;

import com.senla.intership.boot.api.service.PostService;
import com.senla.intership.boot.dto.PostDto;
import com.senla.intership.boot.dto.PostWithAllDto;
import com.senla.intership.boot.dto.PostWithProfileDto;
import com.senla.intership.boot.dto.PostWithReactionsDto;
import com.senla.intership.boot.util.SortHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/posts")
@Validated
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> create (@RequestBody @Valid PostDto request){
        PostDto response = postService.create(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostWithAllDto> get (@PathVariable @NotNull(message = "Post id can not be null")
                                                   @Positive(message = "Post id can not be negative") Long id){
        PostWithAllDto response = postService.read(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable @NotNull(message = "Post id can not be null")
                                                      @Positive(message = "Post id can not be negative") Long id){
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PostWithProfileDto> update(@RequestBody @Valid PostDto request){
        PostWithProfileDto response = postService.update(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{postId}/like")
    public ResponseEntity<PostWithReactionsDto> like(@PathVariable @NotNull(message = "Post id can not be null")
                                                         @Positive(message = "Post id can not be negative") Long postId){
        PostWithReactionsDto response = postService.setReaction(postId,true);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{postId}/dislike")
    public ResponseEntity<PostWithReactionsDto> dislike (@PathVariable @NotNull(message = "Post id can not be null")
                                                             @Positive(message = "Post id can not be negative") Long postId){
        PostWithReactionsDto response = postService.setReaction(postId,false);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PostWithAllDto>> getAll(@RequestParam(required = false, defaultValue = "id") String sort,
                                                            @RequestParam(required = false, defaultValue = "0") Integer page,
                                                            @RequestParam(required = false, defaultValue = "asc")String direction,
                                                            @RequestParam(required = false, defaultValue = "10")Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.by(SortHelper.orderDirection(direction),sort));
        Page<PostWithAllDto> result = postService.findAll(pageable);
        return ResponseEntity.ok(result.getContent());
    }
}
