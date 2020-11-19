package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.model.AppManagerUser;
import com.agileexpert.appmanager.repository.AppManagerUserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private AppManagerUser currentLoggedInUser;
    private final AppManagerUserRepository appManagerUserRepository;

    public void addUser(AppManagerUser appManagerUser) {
        try {
            appManagerUserRepository.save(appManagerUser);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error occurred while saving user to the database.");
        }

    }

    public Optional<AppManagerUser> searchUserByNameAndPassword(String username, String password) {
        return appManagerUserRepository
                .findByUsernameAndPassword(username, password);
    }

    public void afterSuccessfulLogin(AppManagerUser appManagerUser) {
        setCurrentLoggedInUser(appManagerUser);
    }

}
