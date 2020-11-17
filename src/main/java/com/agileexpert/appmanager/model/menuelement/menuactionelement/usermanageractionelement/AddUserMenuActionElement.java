package com.agileexpert.appmanager.model.menuelement.menuactionelement.usermanageractionelement;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddUserMenuActionElement implements MenuElement {

    private final UserService userService;
    private static final String ACTION_ELEMENT_NAME = "Add user";

    @Override
    public void handleAction(){
        System.out.println("Handle AddUser action.");
    }

    @Override
    public String getElementName() {
        return ACTION_ELEMENT_NAME;
    }
}
