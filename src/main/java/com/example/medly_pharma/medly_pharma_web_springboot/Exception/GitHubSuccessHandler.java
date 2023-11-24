package com.example.medly_pharma.medly_pharma_web_springboot.Exception;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;
@Component
public class GitHubSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Set<String> roles = AuthorityUtils.authorityListToSet(oAuth2User.getAuthorities());
        System.out.println("Roles from GitHub: " + roles);

        System.out.println("Before redirect");
        if (roles.contains("OAUTH2_USER")) {
            // Redirect users with OAUTH2_USER role to the specified page
            System.out.println("Redirecting to /users/shop");
            response.sendRedirect("/users/shop");
        } else {
            // For other roles or no specific role, redirect to an error page
            System.out.println("Redirecting to /error");
            response.sendRedirect("/error");
        }

        System.out.println("After redirect");



    }
}
