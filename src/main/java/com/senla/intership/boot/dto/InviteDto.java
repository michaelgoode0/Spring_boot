package com.senla.intership.boot.dto;

import com.senla.intership.boot.enums.InviteStatus;
import lombok.Data;

import java.util.Date;

@Data
public class InviteDto {
    private Long id;
    private Date dateOfInvite;
    private InviteStatus status;
    private UserProfileWithUserDto userFrom;
    private UserProfileWithUserDto userTo;
}
