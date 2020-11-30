package ru.las.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.las.dao.InvitationDao;
import ru.las.service.inviter.Inviter;

import java.util.List;

@Service
public class InvitationServiceImpl implements InvitationService {

    private final InvitationDao invitationDao;
    private final Inviter inviter;
    private final int application;

    @Autowired
    public InvitationServiceImpl(InvitationDao invitationDao,
                                 Inviter inviter,
                                 @Value("${application.number}") int application) {
        this.invitationDao = invitationDao;
        this.inviter = inviter;
        this.application = application;
    }

    public void invite(List<String> phoneNumbers, String message, int author) {
        inviter.sendInvites(phoneNumbers, message);
        invitationDao.create(phoneNumbers, author, application);
    }

    @Override
    public boolean checkInvite(String phoneNumber) {
        return invitationDao.checkInvite(phoneNumber);
    }
}
