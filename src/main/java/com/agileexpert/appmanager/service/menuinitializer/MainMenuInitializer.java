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
    private Map<String, MenuElement> subElements = new HashMap<>();

    @Override
    public void initialize() {
        menuElement = MenuNavigationElement.builder()
                .menuElementName("Main menu")
                .build();
    }

    @Override
    public void linkMenuElements() {
        userManagerMenuInitializer.getMenuElement().setPreviousMenuNavigationElement(menuElement);
        MenuElement userManager = userManagerMenuInitializer.getMenuElement();
        subElements.put(Integer.toString(subElements.size() +1), userManager);
        subElements.put(Integer.toString(subElements.size() +1), userManager);
        menuElement.setMenuElements(subElements);
    }

}
