package com.springapp.mvc.services;

import com.springapp.mvc.common.UserInfo;
import com.springapp.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void add(UserInfo user) {
        userRepository.save(user);
    }

    @Transactional
    public void update(UserInfo user) {
        userRepository.save(user);
    }

    public UserInfo getUserByLogin(String login) {
        return userRepository.getUserInfoByLogin(login);
    }

    private String getAut() {
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

    public UserInfo getAutUser() {
        String username = getAut();
        if (!username.equals("anonymousUser")) {
            return getUserByLogin(username);
        }else return null;
    }
}

