package com.senla.intership.boot.api.service;

import com.senla.intership.boot.dto.profile.UserProfileDto;
import com.senla.intership.boot.dto.profile.UserProfileWithAllDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserProfileService  {
    UserProfileDto update(UserProfileDto userProfileDto);
    UserProfileWithAllDto read(Long id);
    void delete(Long id);
    Page<UserProfileDto> findAll(Pageable pageable);
    Page<UserProfileDto> findFriends(Pageable pageable);
}
