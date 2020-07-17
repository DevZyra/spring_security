package pl.devzyra.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static pl.devzyra.spring_security.config.UserRole.ADMIN;
import static pl.devzyra.spring_security.config.UserRole.STUDENT;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/","index","/css/*","/js/*")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        UserDetails samKnightUser = User.builder()
                .username("samknight")
                .password(passwordEncoder.encode("password"))
                .roles(STUDENT.name()) // ROLE_STUDENT
                .build();

        UserDetails adminUser = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password123"))
                .roles(ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager( samKnightUser, adminUser );
    }

}
