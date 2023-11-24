package com.example.medly_pharma.medly_pharma_web_springboot.Exception;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@Component
public class YourCustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Authentication authentication) throws IOException, jakarta.servlet.ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            response.sendRedirect("/seller/dashboard"); // Redirect recruiter to recruiter profile page
        } else if (roles.contains("ROLE_USERS")) {
            response.sendRedirect("/users/shop"); // Redirect candidate to job listing page
        } else {
            // If the user doesn't have any of the specified roles, redirect to a default page.
            response.sendRedirect("/error");
        }

    }

}

