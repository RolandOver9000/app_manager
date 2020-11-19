package com.agileexpert.appmanager.service.menuinitializer;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.model.menuelement.actionelement.usermanager.AddUser;
import com.agileexpert.appmanager.model.menuelement.navigationelement.MenuNavigationElement;
import com.agileexpert.appmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class UserManagerMenuInitializer extends MenuInitializer{

    private final UserService userService;
    private final AddUser addUser;
    private Map<String, MenuElement> subElements = new HashMap<>();

    @Override
    public void initialize() {
        menuElement = MenuNavigationElement.builder()
                .menuElementName("User manager")
                .build();
    }

    @Override
    public void linkMenuElements() {
        addUser.setPreviousMenuElement(menuElement);
        if(userService.getCurrentLoggedInUser().isUserFamilyHead()) {
            subElements.put(Integer.toString(subElements.size() + 1), addUser);
            menuElement.setMenuElements(subElements);
        }
        subElements.put(Integer.toString(subElements.size() + 1), addUser);
        menuElement.setMenuElements(subElements);
    }

}
