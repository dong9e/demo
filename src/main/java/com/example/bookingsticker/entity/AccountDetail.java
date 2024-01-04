package com.example.bookingsticker.entity;

import javax.persistence.Column;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

@Data
public class AccountDetail implements UserDetails {

    private Long id;
    private String username;
    private String email;
    private String fullname;
    private String gender;
    private String status;
    private String phone;

    private AccountDetail(){

    }

    public AccountDetail(Account account){
        this.id = account.getId();
        this.username = account.getUsername();
        this.fullname = account.getFullname();
        this.email = account.getEmail();
        this.gender = account.getGender().getValue();
        this.status = account.getStatus().getValue();
        this.phone = account.getPhone();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
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
}
