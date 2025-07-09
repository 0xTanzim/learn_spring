package com.eazybytes.eazyschool.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * This class implements AuditorAware to provide the current auditor's
 * information. It retrieves the username of the currently authenticated user
 * from the SecurityContext. If it is an anonymous user or no user is
 * authenticated, it returns an empty Optional. * This is used for auditing
 * purposes in the application, allowing tracking of who created or modified an
 * entity.
 */
@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(
                SecurityContextHolder.getContext().getAuthentication().getName()
        );
    }
}
