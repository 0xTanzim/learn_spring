package com.eazybytes.eazyschool.repository;

import com.eazybytes.eazyschool.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    // ✅ Spring Data Derived Queries — clean, concise
    List<Contact> findByStatus(String status);
    Page<Contact> findByStatusWithPage(String status, Pageable pageable);

    // ✅ Uses @NamedQuery from Entity
    Page<Contact> findOpenMsgs(@Param("status") String status, Pageable pageable);

    // ✅ Uses @NamedQuery from Entity
    @Transactional
    @Modifying
    int updateMsgStatus(@Param("status") String status, @Param("contactId") int contactId);

    // ✅ Custom inline JPQL with explicit @Query
    @Transactional
    @Modifying
    @Query(
            "UPDATE Contact c SET c.status = :status WHERE c.contactId = :contactId"
    )
    int updateStatusById(@Param("contactId") int contactId, @Param("status") String status);


    // ✅ Custom Native SQL Query with explicit @Query
    @Query(nativeQuery = true)
    Page<Contact> findOpenMsgsNative(@Param("status") String status, Pageable pageable);

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    int updateMsgStatusNative(String status, int id);
}
