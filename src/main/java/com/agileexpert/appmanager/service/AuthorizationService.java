package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.service.menuinitializer.AuthenticationMenuInitializer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final AuthenticationMenuInitializer authenticationMenuInitializer;

    public void doAuthorization() {
        authenticationMenuInitializer.initialize();
        authenticationMenuInitializer.linkMenuElements();
        authenticationMenuInitializer.getMenuElement().handleMenuInteraction();
    }
}
