package com.example.bookingsticker.service.impl;

import com.example.bookingsticker.entity.Account;
import com.example.bookingsticker.entity.AccountDetail;
import com.example.bookingsticker.exception.CustomException;
import com.example.bookingsticker.repository.AccountRepository;
import com.example.bookingsticker.service.AccountService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (Objects.isNull(account))
            throw CustomException.NOT_FOUND.withMessage("").addError("");
        return new AccountDetail(account);
    }
}
