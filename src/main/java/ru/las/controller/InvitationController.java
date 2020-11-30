package ru.las.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        invitationService.invite(
                invitationDto.getNumbers(),
                invitationDto.getMessage(),
                invitationDto.getAuthor()
        );
    }

    @GetMapping("/check/{number}")
    public boolean check(@PathVariable("number") String phoneNumber) {
        return invitationService.checkInvite(phoneNumber);
    }

}
