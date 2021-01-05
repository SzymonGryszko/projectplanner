package com.gryszkoszymon.projectplanner.security.oauth2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gryszkoszymon.projectplanner.model.AuthProvider;
import com.gryszkoszymon.projectplanner.model.User;
import com.gryszkoszymon.projectplanner.repository.UserRepository;
import com.gryszkoszymon.projectplanner.service.UserService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private OAuth2AuthorizedClientService clientService;
    @Autowired
    private UserService userService;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();


        Long databaseUserId = handleUserAfterAuthenticationSuccess(oAuth2User);
        String targetUrl = "http://localhost:4200/boards/" + databaseUserId;
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    private Long handleUserAfterAuthenticationSuccess(CustomOAuth2User oAuth2User) {
        String email = oAuth2User.getEmail();
        String name = oAuth2User.getName();
        String pictureUrl = oAuth2User.getPictureURL();
        AuthProvider authProvider = AuthProvider.GOOGLE;
        Optional<User> optionalUser = userService.findUserByEmail(oAuth2User.getEmail());
        if (optionalUser.isEmpty()) {
            return userService.setupUserAfterFirstLogin(email, name, pictureUrl, authProvider);
        } else {
            return userService.updateUserAfterLogin(optionalUser.get(), name, pictureUrl);
        }
    }
}
