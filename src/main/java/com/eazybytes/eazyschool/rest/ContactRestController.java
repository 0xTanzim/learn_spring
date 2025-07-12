package com.eazybytes.eazyschool.rest;

import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api/contact")
public class ContactRestController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/messages")
    @ResponseBody
    public List<Contact> getMessagesByStatus(@RequestParam(value = "status", required = false) String status){
        return  contactRepository.findByStatus(status);
    }


    @GetMapping("/getAllMsgsByStatus")
    @ResponseBody
    public List<Contact> getAllMsgsByStatus(@RequestBody Contact contact){

        if(null != contact && null != contact.getStatus()){
            return contactRepository.findByStatus(contact.getStatus());
        }else{
            return List.of();
        }
    }
}
