package ru.las.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.las.dto.InvitationDto;
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
    public void invite(@RequestBody InvitationDto invitationDto) {
        invitationService.sendInvites(
                invitationDto.getNumbers(),
                invitationDto.getMessage(),
                invitationDto.getAuthor()
        );
    }

}
