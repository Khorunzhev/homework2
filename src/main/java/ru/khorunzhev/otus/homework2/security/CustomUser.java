package ru.khorunzhev.otus.homework2.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.khorunzhev.otus.homework2.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CustomUser implements UserDetails {

    private final String userName;
    private final String password;
    private final List<SimpleGrantedAuthority> simpleGrantedAuthorityList;

    public CustomUser(String userName, String password, List<SimpleGrantedAuthority> simpleGrantedAuthorityList) {
        this.userName = userName;
        this.password = password;
        this.simpleGrantedAuthorityList = simpleGrantedAuthorityList;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return simpleGrantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static UserDetails fromUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        user.getRole().getAuthorities()
                );
    }
}
