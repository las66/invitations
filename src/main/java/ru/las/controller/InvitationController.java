package ru.las.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.las.exception.AppException;
import ru.las.model.dto.InvitationsDto;
import ru.las.service.InvitationService;
import ru.las.service.InvitationServiceImpl;

@RestController
@RequestMapping("/invitation")
public class InvitationController {

    private final InvitationService invitationService;

    @Autowired
    public InvitationController(InvitationServiceImpl invitationService) {
        this.invitationService = invitationService;
    }

    @PostMapping("/invite")
    public void invite(@RequestBody InvitationsDto invitationDto) {
        try {
            invitationService.invite(invitationDto.getPhoneNumbers(), invitationDto.getMessage(), invitationDto.getAuthor());
        } catch (Exception e) {
            throw new AppException(e);
        }
    }

    @GetMapping("/check/{phoneNumber}")
    public boolean check(@PathVariable("phoneNumber") String phoneNumber) {
        return invitationService.checkInvite(phoneNumber);
    }

}
