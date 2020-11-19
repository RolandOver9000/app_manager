package com.agileexpert.appmanager.service.menuinitializer;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.model.menuelement.navigationelement.MenuNavigationElement;
import com.agileexpert.appmanager.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class MainMenuInitializer extends MenuInitializer {

    private final UserManagerMenuInitializer userManagerMenuInitializer;
    private final ConsoleSettingsMenuInitializer consoleSettingsMenuInitializer;
    private final ApplicationMenuInitializer applicationMenuInitializer;
    private Map<String, MenuElement> subElements = new HashMap<>();

    @Override
    public void initialize() {
        menuElement = MenuNavigationElement.builder()
                .menuElementName("Main menu")
                .build();
    }

    @Override
    public void linkMenuElements() {
        userManagerMenuInitializer.setPreviousNavigationMenuElement(menuElement);
        consoleSettingsMenuInitializer.setPreviousNavigationMenuElement(menuElement);
        applicationMenuInitializer.setPreviousNavigationMenuElement(menuElement);

        MenuElement userManager = userManagerMenuInitializer.getMenuElement();
        MenuElement consoleSettings = consoleSettingsMenuInitializer.getMenuElement();
        MenuElement applications = applicationMenuInitializer.getMenuElement();

        subElements.put(Integer.toString(subElements.size() +1), userManager);
        subElements.put(Integer.toString(subElements.size() + 1), consoleSettings);
        subElements.put(Integer.toString(subElements.size() + 1), applications);
        menuElement.setMenuElements(subElements);
    }

}
