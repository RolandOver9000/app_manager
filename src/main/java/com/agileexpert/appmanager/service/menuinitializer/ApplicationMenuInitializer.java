package com.agileexpert.appmanager.service.menuinitializer;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.model.menuelement.actionelement.application.InstalledApplications;
import com.agileexpert.appmanager.model.menuelement.navigationelement.MenuNavigationElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ApplicationMenuInitializer extends MenuInitializer{

    private final InstalledApplications installedApplications;
    private Map<String, MenuElement> subElements = new HashMap<>();

    @Override
    public void initialize() {
        menuElement = MenuNavigationElement.builder()
                .menuElementName("Application menu")
                .build();
    }

    @Override
    public void linkMenuElements() {
        installedApplications.setPreviousMenuElement(menuElement);
        subElements.put(Integer.toString(subElements.size() +1), installedApplications);
        menuElement.setMenuElements(subElements);
    }

}
