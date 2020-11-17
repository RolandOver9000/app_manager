package com.agileexpert.appmanager.service.usermanager;

import com.agileexpert.appmanager.model.menuelement.menunavigationelement.UserManager;
import com.agileexpert.appmanager.model.menuelement.menuactionelement.usermanageractionelement.AddUserMenuActionElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserManagerMenuInitializer {

    private final AddUserMenuActionElement addUserMenuActionElement;
    private final UserManager userManager;

    public void initializeUserManagerMenu() {
        userManager.addMenuActionElement(addUserMenuActionElement);
    }

}
