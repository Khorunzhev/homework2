package ru.khorunzhev.otus.homework2.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.khorunzhev.otus.homework2.model.Permission;
import ru.khorunzhev.otus.homework2.model.Role;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailService customUserDetailService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests().antMatchers("/login*").permitAll()
            .and()
            .authorizeRequests().antMatchers("/books/edit").hasAnyAuthority(Permission.BOOK_WRITE.getPermission())
            .and()
            .authorizeRequests().antMatchers("/books/create").hasAnyAuthority(Permission.BOOK_WRITE.getPermission())
            .and()
            .authorizeRequests().antMatchers("/books**").hasAnyAuthority(Permission.BOOK_READ.getPermission())
            .and()
            .authorizeRequests().antMatchers("/comment/**").hasAnyAuthority(Permission.BOOK_WRITE.name())
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginProcessingUrl("/perform_login")
            .defaultSuccessUrl("/books", true)
            .and()
            .logout()
            .logoutUrl("/perform_logout")
            .deleteCookies("JSESSIONID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(customUserDetailService);
        return daoAuthenticationProvider;
    }

}
