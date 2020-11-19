package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.model.AppManagerUser;
import com.agileexpert.appmanager.model.Family;
import com.agileexpert.appmanager.repository.AppManagerUserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Data
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private AppManagerUser currentLoggedInUser;
    private final FamilyService familyService;
    private final AppManagerUserRepository appManagerUserRepository;

    public void addUser(String username, String password) {
        try {
            AppManagerUser newUser = AppManagerUser.builder()
                    .username(username)
                    .password(password)
                    .build();
            Family currentUserFamily = familyService.getFamilyByFamilyHead(currentLoggedInUser);

            newUser.setUserFamily(currentUserFamily);
            appManagerUserRepository.save(newUser);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error occurred while saving user to the database.");
        }
    }

    public void addFamilyHead(String username, String password) {
        AppManagerUser newAppManagerUser = AppManagerUser.builder()
                .username(username)
                .password(password)
                .isUserFamilyHead(true)
                .build();

        Family newFamily = Family.builder()
                .build();

        newAppManagerUser.setUserFamily(newFamily);
        newFamily.setFamilyHead(newAppManagerUser);

        appManagerUserRepository.save(newAppManagerUser);
        familyService.createNewFamily(newFamily);
    }

    public boolean isUserExist(String username, String password) {
        Optional<AppManagerUser> searchedAppManagerUser =
                appManagerUserRepository.findByUsernameAndPassword(username, password);
        if(searchedAppManagerUser.isPresent()) {
            afterSuccessfulLogin(searchedAppManagerUser.get());
            return true;
        }
        return false;
    }

    public void afterSuccessfulLogin(AppManagerUser appManagerUser) {
        setCurrentLoggedInUser(appManagerUser);
    }

}
