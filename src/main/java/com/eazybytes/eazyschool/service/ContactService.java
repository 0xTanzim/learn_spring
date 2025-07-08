package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.constants.EazySchoolConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service

@ApplicationScope
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;


    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        System.out.println("Contact Details: " + contact);

        Contact result = contactRepository.save(contact);

        if(result != null && result.getContactId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus(EazySchoolConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;

        Optional<Contact> contactOptional = contactRepository.findById(contactId);

        contactOptional.ifPresent(contact -> {
            contact.setStatus(EazySchoolConstants.CLOSE);
        });

        Contact result = contactRepository.save(contactOptional.get());

        if(result != null && result.getContactId() > 0) {
            isUpdated = true;
        }

        return isUpdated;
    }
}
