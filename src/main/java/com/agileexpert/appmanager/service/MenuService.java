package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.service.menuinitializer.MainMenuInitializer;
import com.agileexpert.appmanager.service.menuinitializer.UserManagerMenuInitializer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MenuService {

    private final AuthorizationService authorizationService;
    private final MainMenuInitializer mainMenuInitializer;
    private final UserManagerMenuInitializer userManagerMenuInitializer;

    public void startAppManagerApplication() {
        doAuthorization();
    }

    private void doAuthorization() {
        authorizationService.doAuthorization();
        initializeMenuElements();
        linkMenuElements();
    }

    private void initializeMenuElements() {
        userManagerMenuInitializer.initialize();
        mainMenuInitializer.initialize();
    }

    private void linkMenuElements() {
        userManagerMenuInitializer.linkMenuElements();
        mainMenuInitializer.linkMenuElements();
    }
}
