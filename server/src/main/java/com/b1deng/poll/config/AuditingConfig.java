package com.b1deng.poll.config;

import com.b1deng.poll.security.UserPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {

    class SpringSecurityAuditAwareImpl implements AuditorAware<Long> {

        @Override
        public Optional<Long> getCurrentAuditor() {
            return Optional.ofNullable(SecurityContextHolder.getContext())
                    .map(SecurityContext::getAuthentication)
                    .filter(Authentication::isAuthenticated)
                    .map(Authentication::getPrincipal)
                    .map(UserPrincipal.class::cast)
                    .map(UserPrincipal::getId);
        }
    }

    @Bean
    public AuditorAware<Long> auditorProvider() {
        return new SpringSecurityAuditAwareImpl();
    }
}
