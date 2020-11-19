package com.agileexpert.appmanager.model.menuelement.actionelement;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.service.AuthorizationService;
import com.agileexpert.appmanager.service.UserService;
import com.agileexpert.appmanager.service.util.Util;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class Login implements MenuElement {

    private final AuthorizationService authorizationService;
    private String menuElementName = "Login";
    private MenuElement previousMenuElement;
    private MenuElement menuElementAfterSuccessfulLogin;

    @Override
    public void handleMenuInteraction() {
        getLoginInputs();
    }

    private void getLoginInputs() {
        System.out.println("Please give me your username: ");
        String username = Util.readUserInput();
        System.out.println("Please give me your password: ");
        String password = Util.readUserInput();
        handleLoginInputs(username, password);
    }

    private void handleLoginInputs(String username, String password) {
        boolean isLoginSuccessful =
                authorizationService.isUserCanLoginWithUsernameAndPassword(username, password);
        if(isLoginSuccessful) {
            System.out.println("Welcome " + username + "!");
            authorizationService.handleSuccessfulLogin();
        } else {
            System.out.println("Your username or password is not correct.");
            previousMenuElement.handleMenuInteraction();
        }
    }

    @Override
    public String getMenuElementName() {
        return menuElementName;
    }
}
