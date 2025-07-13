package com.eazybytes.eazyschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.eazybytes.eazyschool.constants.EazySchoolConstants;
import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

@ApplicationScope
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(final Contact contact) {
        boolean isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        System.out.println("Contact Details: " + contact);

        final Contact result = this.contactRepository.save(contact);

        if (result != null && result.getContactId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public Page<Contact> findMsgsWithOpenStatus(final int pageNum, final String sortField, final String sortDir) {
        final int pageSize = 5;
        final Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                "asc".equals(sortDir) ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        return this.contactRepository.findAllByStatus
                (
                EazySchoolConstants.OPEN, pageable);
    }

    public boolean updateMsgStatus(final int contactId) {
        boolean isUpdated = false;

        final int rows = this.contactRepository.updateStatusById(
                contactId, EazySchoolConstants.CLOSE);

        if (rows > 0) {
            isUpdated = true;
            ContactService.log.info("Contact with ID {} updated successfully.", contactId);
        } else {
            ContactService.log.warn("No contact found with ID {} to update.", contactId);
        }

        return isUpdated;
    }
}
