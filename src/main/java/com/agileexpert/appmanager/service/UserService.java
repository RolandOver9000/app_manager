package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.model.AppManagerUser;
import com.agileexpert.appmanager.repository.AppManagerUserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final AppManagerUserRepository appManagerUserRepository;

    public void addUser(AppManagerUser appManagerUser) {
        try {
            appManagerUserRepository.save(appManagerUser);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error occurred while saving user to the database.");
        }

    }

    public AppManagerUser searchUserByNameAndPassword(String username, String password) {
        return appManagerUserRepository
                .findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new UsernameNotFoundException("User not found by name: " + username));
    }

}
