package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.service.menuinitializer.AuthenticationMenuInitializer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final AuthorizationService authorizationService;
    private final AuthenticationMenuInitializer authenticationMenuInitializer;

    @Override
    public void run(String...args) {
        authenticationMenuInitializer.initialize();
        authenticationMenuInitializer.linkMenuElements();
        authenticationMenuInitializer.getMenuElement().handleMenuInteraction();
    }
}
