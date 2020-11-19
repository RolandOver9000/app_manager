package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.model.AppManagerUser;
import com.agileexpert.appmanager.service.menuinitializer.AuthenticationMenuInitializer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserService userService;
    private final AuthenticationMenuInitializer authenticationMenuInitializer;

    public Optional<AppManagerUser> searchUserByNameAndPassword(String username, String password) {
        return userService.searchUserByNameAndPassword(username, password);
    }

    public void afterSuccessfulLogin(AppManagerUser loggedinAppManagerUser) {
        userService.afterSuccessfulLogin(loggedinAppManagerUser);
    }

    public void doAuthorization() {
        authenticationMenuInitializer.initialize();
        authenticationMenuInitializer.linkMenuElements();
        authenticationMenuInitializer.getMenuElement().handleMenuInteraction();
    }
}
