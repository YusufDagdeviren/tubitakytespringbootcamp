package yte.inter.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration {
    public SecurityConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        UserDetails user = User.builder()
                .username("yusuf")
                .password("yusuf")
                .authorities("ROLE_USER")
                .build();
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(user)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
