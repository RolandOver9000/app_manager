package com.agileexpert.appmanager.model.menuelement.actionelement.usermanager;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.service.UserService;
import com.agileexpert.appmanager.service.util.Util;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class AddUser implements MenuElement {


    private final UserService userService;
    private String menuElementName = "Add user";

    @Override
    public void handleMenuInteraction() {
        addUser();
    }

    private void addUser() {
        System.out.println("Please give me a username: ");
        String newUsername = Util.readUserInput();
        System.out.println("Please give me a password: ");
        String newPassword = Util.readUserInput();

        userService.addUser(newUsername, newPassword);
        System.out.println("User saved.");
    }
}
