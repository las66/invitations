package ru.las.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.las.dao.InvitationDao;
import ru.las.service.inviter.Inviter;
import ru.las.validator.PhoneNumberValidator;

import java.util.List;

@Service
public class InvitationServiceImpl implements InvitationService {

    private final InvitationDao invitationDao;
    private final Inviter inviter;
    private final PhoneNumberValidator phoneNumberValidator;
    private final int application;

    @Autowired
    public InvitationServiceImpl(InvitationDao invitationDao,
                                 Inviter inviter,
                                 PhoneNumberValidator phoneNumberValidator,
                                 @Value("${application.number}") int application) {
        this.invitationDao = invitationDao;
        this.inviter = inviter;
        this.phoneNumberValidator = phoneNumberValidator;
        this.application = application;
    }

    public void invite(List<String> phoneNumbers, String message, int author) {
        phoneNumberValidator.validateListSize(phoneNumbers);
        phoneNumberValidator.validateFormat(phoneNumbers);

        inviter.sendInvites(phoneNumbers, message);
        invitationDao.create(phoneNumbers, author, application);
    }

    @Override
    public boolean checkInvite(String phoneNumber) {
        return invitationDao.checkInvite(phoneNumber);
    }
}
