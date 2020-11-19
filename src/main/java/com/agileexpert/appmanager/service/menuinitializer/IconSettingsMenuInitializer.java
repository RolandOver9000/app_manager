package com.agileexpert.appmanager.service.menuinitializer;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.model.menuelement.actionelement.icon.AddIcon;
import com.agileexpert.appmanager.model.menuelement.navigationelement.MenuNavigationElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class IconSettingsMenuInitializer extends MenuInitializer {

    private final AddIcon addIcon;
    private Map<String, MenuElement> subElements = new HashMap<>();

    @Override
    public void initialize() {
        menuElement = MenuNavigationElement.builder()
                .menuElementName("Icon settings menu")
                .build();
    }

    @Override
    public void linkMenuElements() {
        subElements.put(Integer.toString(subElements.size() +1), addIcon);
        menuElement.setMenuElements(subElements);
    }
}
