package org.example;

import org.apache.log4j.Logger;
import org.example.app.services.UserService;
import org.example.web.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthencationProvider implements AuthenticationProvider {
    private Logger logger = Logger.getLogger(CustomAuthencationProvider.class);
    @Autowired
    private UserService repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder();
//    }
    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (repo.authenticate(new User(userName,password)))
        {

            UserDetails principal =  org.springframework.security.core.userdetails.User.builder()
                .username(userName)
               .password(passwordEncoder.encode(password))
                .roles("USER")
                .build();
            return new UsernamePasswordAuthenticationToken(
                    principal, password, principal.getAuthorities());
        }
        logger.error("Wrong username or password "+userName+" "+password);
        throw new BadCredentialsException("Wrong username or password");

    }
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}