package com.agileexpert.appmanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final UserService userService;
    private final MenuService menuService;

    public boolean isUserCanLoginWithUsernameAndPassword(String username, String password) {
        return userService.isUserExist(username, password);
    }

    public void handleSuccessfulLogin() {
        menuService.afterSuccessfulLogin();
    }

    public void handleRegistration(String familyHeadUsername, String familyHeadPassword) {
        userService.addFamilyHead(familyHeadUsername, familyHeadPassword);
    }
}
