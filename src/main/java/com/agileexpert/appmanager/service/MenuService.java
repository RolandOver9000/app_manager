package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.service.menuinitializer.AuthenticationMenuInitializer;
import com.agileexpert.appmanager.service.menuinitializer.MainMenuInitializer;
import com.agileexpert.appmanager.service.menuinitializer.MenuInitializer;
import com.agileexpert.appmanager.service.menuinitializer.UserManagerMenuInitializer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final AuthenticationMenuInitializer authenticationMenuInitializer;
    private final MainMenuInitializer mainMenuInitializer;
    private final UserManagerMenuInitializer userManagerMenuInitializer;

    public void startAppManagerApplication() {
        initializeMenuElements();
        linkMenuElements();
        authenticationMenuInitializer.getMenuElement().handleMenuInteraction();
    }

    private void initializeMenuElements() {
        authenticationMenuInitializer.initialize();
        userManagerMenuInitializer.initialize();
        mainMenuInitializer.initialize();
    }

    private void linkMenuElements() {
        authenticationMenuInitializer.linkMenuElements();
        userManagerMenuInitializer.linkMenuElements();
        mainMenuInitializer.linkMenuElements();
    }

}
