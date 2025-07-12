package com.eazybytes.eazyschool.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "contact_msg")

// ================= JPQL Named Queries =================
@NamedQueries({
        @NamedQuery(
                name = "Contact.findOpenMsgs",
                query = "SELECT c FROM Contact c WHERE c.status = :status"
        ),
        @NamedQuery(
                name = "Contact.updateMsgStatus",
                query = "UPDATE Contact c SET c.status = :status WHERE c.contactId = :contactId"
        )
})

// ================= Native SQL Named Queries =================
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Contact.findOpenMsgsNative",
                query = "SELECT * FROM contact_msg c WHERE c.status = :status",
                resultClass = Contact.class
        ),
        @NamedNativeQuery(
                name = "Contact.findOpenMsgsNative.count",
                query = "SELECT COUNT(*) as cnt FROM contact_msg c WHERE c.status = :status",
                resultSetMapping = "Contact.CountMapping"
        ),
        @NamedNativeQuery(
                name = "Contact.updateMsgStatusNative",
                query = "UPDATE contact_msg SET status = :status WHERE contact_id = :contactId"
        )

})

// ================= Result Set Mapping =================
@SqlResultSetMapping(
        name = "Contact.CountMapping",
        columns = @ColumnResult(name = "cnt", type = Long.class)
)

public class Contact extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private int contactId;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    @NotBlank(message = "Mobile number must not be blank")
    private String mobileNum;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Subject must not be blank")
    @Size(min = 5, message = "Subject must be at least 5 characters long")
    private String subject;

    @NotBlank(message = "Message must not be blank")
    @Size(min = 10, message = "Message must be at least 10 characters long")
    private String message;

    private String status;
}
