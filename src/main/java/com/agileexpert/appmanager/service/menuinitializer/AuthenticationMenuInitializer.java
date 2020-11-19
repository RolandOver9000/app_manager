package com.agileexpert.appmanager.service.menuinitializer;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.model.menuelement.actionelement.authentication.Login;
import com.agileexpert.appmanager.model.menuelement.actionelement.authentication.Registration;
import com.agileexpert.appmanager.model.menuelement.navigationelement.MenuNavigationElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AuthenticationMenuInitializer extends MenuInitializer{

    private final Registration registration;
    private final Login login;
    private Map<String, MenuElement> subElements = new HashMap<>();

    @Override
    public void initialize() {
        menuElement = MenuNavigationElement.builder()
                .menuElementName("Authentication menu")
                .build();
    }

    @Override
    public void linkMenuElements() {
        registration.setPreviousMenuElement(menuElement);
        login.setPreviousMenuElement(menuElement);
        subElements.put(Integer.toString(subElements.size() +1), registration);
        subElements.put(Integer.toString(subElements.size() +1), login);
        menuElement.setMenuElements(subElements);
    }
}
