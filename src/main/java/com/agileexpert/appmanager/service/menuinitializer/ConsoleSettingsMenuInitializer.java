package com.agileexpert.appmanager.service.menuinitializer;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.model.menuelement.navigationelement.MenuNavigationElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ConsoleSettingsMenuInitializer extends MenuInitializer{

    private final IconSettingsMenuInitializer iconSettingsMenuInitializer;
    private Map<String, MenuElement> subElements = new HashMap<>();

    @Override
    public void initialize() {
        menuElement = MenuNavigationElement.builder()
                .menuElementName("Console settings menu")
                .build();
    }

    @Override
    public void linkMenuElements() {
        iconSettingsMenuInitializer.getMenuElement().setPreviousMenuNavigationElement(menuElement);
        MenuElement iconSettingsMenu = iconSettingsMenuInitializer.getMenuElement();
        subElements.put(Integer.toString(subElements.size() +1), iconSettingsMenu);
        menuElement.setMenuElements(subElements);
    }
}
