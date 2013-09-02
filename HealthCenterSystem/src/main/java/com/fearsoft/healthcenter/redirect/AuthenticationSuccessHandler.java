/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.redirect;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author marlon
 */
    @Component
    public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

       @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
                                            Authentication authentication) throws ServletException, IOException {
            String adminTargetUrl = "/administrador/index.jsp";
            String medTargetUrl = "/medico/index.jsp";
            String enfTargetUrl = "/enfermeiro/index.jsp";
            String recTargetUrl = "/recepcionista/index.jsp";
            
            Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
            if (roles.contains("ROLE_ADMIN")) {
               getRedirectStrategy().sendRedirect(request, response, adminTargetUrl);
            } else if (roles.contains("ROLE_MED")) {
               getRedirectStrategy().sendRedirect(request, response, medTargetUrl);
            } else if (roles.contains("ROLE_ENF")) {
               getRedirectStrategy().sendRedirect(request, response, enfTargetUrl);
            } else if (roles.contains("ROLE_REC")) {
               getRedirectStrategy().sendRedirect(request, response, recTargetUrl);
            } else {
               super.onAuthenticationSuccess(request, response, authentication);
               return;
            }
   }
}