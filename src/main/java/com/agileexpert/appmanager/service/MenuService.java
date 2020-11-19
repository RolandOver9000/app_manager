package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.service.menuinitializer.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MenuService {

    private final MainMenuInitializer mainMenuInitializer;
    private final ApplicationMenuInitializer applicationMenuInitializer;
    private final UserManagerMenuInitializer userManagerMenuInitializer;
    private final ConsoleSettingsMenuInitializer consoleSettingsMenuInitializer;
    private final IconSettingsMenuInitializer iconSettingsMenuInitializer;

    public void afterSuccessfulLogin(){
        initializeMenuElements();
        linkMenuElements();
        mainMenuInitializer.getMenuElement().handleMenuInteraction();
    }

    private void initializeMenuElements() {
        userManagerMenuInitializer.initialize();
        mainMenuInitializer.initialize();
        consoleSettingsMenuInitializer.initialize();
        iconSettingsMenuInitializer.initialize();
        applicationMenuInitializer.initialize();

    }

    private void linkMenuElements() {
        userManagerMenuInitializer.linkMenuElements();
        mainMenuInitializer.linkMenuElements();
        consoleSettingsMenuInitializer.linkMenuElements();
        iconSettingsMenuInitializer.linkMenuElements();
        applicationMenuInitializer.linkMenuElements();
    }
}
