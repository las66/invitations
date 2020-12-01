package ru.las.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.las.converter.TranslitConverter;
import ru.las.dao.InvitationDao;
import ru.las.service.inviter.Inviter;
import ru.las.validator.MessageValidator;
import ru.las.validator.PhoneNumberValidator;

import java.util.List;

@Service
public class InvitationServiceImpl implements InvitationService {

    private final InvitationDao invitationDao;
    private final Inviter inviter;
    private final PhoneNumberValidator phoneNumberValidator;
    private final MessageValidator messageValidator;
    private final TranslitConverter transitConverter;
    private final int application;

    @Autowired
    public InvitationServiceImpl(InvitationDao invitationDao,
                                 Inviter inviter,
                                 PhoneNumberValidator phoneNumberValidator,
                                 MessageValidator messageValidator,
                                 TranslitConverter transitConverter,
                                 @Value("${application.number}") int application) {
        this.invitationDao = invitationDao;
        this.inviter = inviter;
        this.phoneNumberValidator = phoneNumberValidator;
        this.messageValidator = messageValidator;
        this.transitConverter = transitConverter;
        this.application = application;
    }

    public void invite(List<String> phoneNumbers, String message, int author) {
        phoneNumberValidator.validateListSize(phoneNumbers);
        phoneNumberValidator.validateFormat(phoneNumbers);
        phoneNumberValidator.validateNumberPerDay(phoneNumbers, invitationDao.todayCount(application));
        phoneNumberValidator.validateDuplicates(phoneNumbers);
        messageValidator.validateMinSize(message);

        String translitMessage = transitConverter.cyrillicToLatin(message);
        messageValidator.validateGsmString(translitMessage);
        messageValidator.validateMaxSize(translitMessage);

        inviter.sendInvites(phoneNumbers, message);

        invitationDao.create(phoneNumbers, author, application);
    }

    @Override
    public boolean checkInvite(String phoneNumber) {
        return invitationDao.checkInvite(phoneNumber);
    }
}
