package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.model.AppManagerUser;
import com.agileexpert.appmanager.model.ConsoleSettings;
import com.agileexpert.appmanager.model.Family;
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
    private final FamilyService familyService;
    private final ConsoleSettingsService consoleSettingsService;
    private final AppManagerUserRepository appManagerUserRepository;

    public void addUser(String username, String password) {
        try {
            AppManagerUser newUser = AppManagerUser.builder()
                    .username(username)
                    .password(password)
                    .build();
            Family currentUserFamily = familyService.getFamilyByFamilyHead(currentLoggedInUser);
            System.out.println(currentLoggedInUser.toString());
            AppManagerUser savedAppManagerUser = appManagerUserRepository.save(newUser);
            savedAppManagerUser.setUserFamily(currentUserFamily);
            appManagerUserRepository.save(savedAppManagerUser);


            System.out.println("new user " + newUser.toString());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error occurred while saving user to the database.");
        }
    }

    public void addFamilyHead(String username, String password) {
        AppManagerUser newUser = AppManagerUser.builder()
                .username(username)
                .password(password)
                .isUserFamilyHead(true)
                .build();

        Family newFamily = familyService.getNewFamilyObject();
        consoleSettingsService.setConsoleSettingsForRegisteredUser(newUser);
        AppManagerUser savedAppManagerUser = appManagerUserRepository.save(newUser);
        Family savedFamily = familyService.createNewFamily(newFamily);
        connectFamilyHeadWithFamily(savedFamily, savedAppManagerUser);

    }

    private void connectFamilyHeadWithFamily(Family savedFamily, AppManagerUser savedAppManagerUser) {
        savedAppManagerUser.setUserFamily(savedFamily);
        savedFamily.setFamilyHead(savedAppManagerUser);
        appManagerUserRepository.save(savedAppManagerUser);
        familyService.createNewFamily(savedFamily);
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
