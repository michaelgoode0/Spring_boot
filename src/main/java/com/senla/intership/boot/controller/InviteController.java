package com.senla.intership.boot.controller;

import com.senla.intership.boot.api.service.InviteService;
import com.senla.intership.boot.dto.InviteDto;
import com.senla.intership.boot.util.AuthNameHolder;
import com.senla.intership.boot.util.SortHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/invites")
public class InviteController {

    private final InviteService inviteService;

    @GetMapping("/{id}")
    public ResponseEntity<InviteDto> sendInvite(@PathVariable Long id){
        InviteDto response = inviteService.sendInvite(id);
        log.info("The user, " + AuthNameHolder.getAuthUsername() + ", got an Invite object with id:" + id);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}/accept")
    public ResponseEntity<InviteDto> acceptInvite(@PathVariable Long id){
        InviteDto response = inviteService.acceptInvite(id);
        log.info("The user, " + AuthNameHolder.getAuthUsername() + ", accepted invite with id:" + id);
        return  ResponseEntity.ok(response);
    }
    @GetMapping("/{id}/deny")
    public ResponseEntity<InviteDto> denyInvite(@PathVariable Long id){
        InviteDto response = inviteService.denyInvite(id);
        log.info("The user, " + AuthNameHolder.getAuthUsername() + ", denied invite with id:" + id);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<InviteDto>> getAll(@RequestParam(required = false, defaultValue = "id") String sort,
                                                  @RequestParam(required = false, defaultValue = "0") Integer page,
                                                  @RequestParam(required = false, defaultValue = "asc") String direction,
                                                  @RequestParam(required = false, defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(SortHelper.orderDirection(direction),sort));
        Page<InviteDto> result = inviteService.findAll(pageable);
        log.info("The user, " + AuthNameHolder.getAuthUsername() + ", got a list of Invites");
        return ResponseEntity.ok(result.getContent());
    }

}
