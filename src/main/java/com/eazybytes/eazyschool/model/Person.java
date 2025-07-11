package com.eazybytes.eazyschool.model;

import com.eazybytes.eazyschool.annotation.FieldsValueMatch;
import com.eazybytes.eazyschool.annotation.PasswordValidator;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@FieldsValueMatch.List({
                @FieldsValueMatch(field = "pwd", fieldMatch = "confirmPwd", message = "The password fields must match"),

                @FieldsValueMatch(field = "email", fieldMatch = "confirmEmail", message = "The email fields must match")
})
public class Person extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int personId;

        @NotBlank(message = "Name must not be blank")
        @Size(min = 3, message = "Name must be at least 3 characters long")
        private String name;

        @NotBlank(message = "Mobile number must not be blank")
        private String mobileNumber;

        @NotBlank(message = "Email must not be blank")
        @Email(message = "Please provide a valid email address")
        private String email;

        @NotBlank(message = "Confirm Email must not be blank")
        @Email(message = "Please provide a valid confirm email address")
        @Transient // it is not a column in the database
        private String confirmEmail;

        @NotBlank(message = "Password must not be blank")
        @Size(min = 6, message = "Password must be at least 6 characters long")
        @PasswordValidator
        private String pwd;

        @NotBlank(message = "Confirm Password must not be blank")
        @Size(min = 6, message = "Confirm Password must be at least 6 characters long")
        @Transient // it is not a column in the database
        private String confirmPwd;

        @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, targetEntity = Roles.class)
        @JoinColumn(name = "role_id", referencedColumnName = "roleId", nullable = false)
        private Roles roles;

        @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Address.class)
        @JoinColumn(name = "address_id", referencedColumnName = "addressId", nullable = true)
        private Address address;


        @ManyToOne(fetch = FetchType.LAZY, optional = true)
        @JoinColumn(name = "class_id", referencedColumnName = "classId", nullable = true)
        private EazyClass eazyClass;

        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
        @JoinTable(name = "person_courses",
                joinColumns = {
                        @JoinColumn(name = "person_id", referencedColumnName = "personId")},
                inverseJoinColumns = {
                        @JoinColumn(name = "course_id", referencedColumnName = "courseId")})
        private Set<Courses> courses = new HashSet<>();

}
