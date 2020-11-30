package ru.las.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.las.dao.InvitationDao;

import java.util.List;

@Service
public class InvitationServiceImpl implements InvitationService {

    private final InvitationDao invitationDao;
    private final int application;

    @Autowired
    public InvitationServiceImpl(InvitationDao invitationDao,
                                 @Value("${application.number}") int application) {
        this.invitationDao = invitationDao;
        this.application = application;
    }

    public void sendInvites(List<String> phoneNumbers, String message, int author) {
        invitationDao.create(phoneNumbers, author, application);
    }
}
