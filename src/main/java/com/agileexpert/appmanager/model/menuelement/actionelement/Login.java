package com.agileexpert.appmanager.model.menuelement.actionelement;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.service.LoginService;
import com.agileexpert.appmanager.service.MenuService;
import com.agileexpert.appmanager.service.util.Util;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class Login implements MenuElement {

    private final LoginService loginService;
    private String menuElementName = "Login";
    private MenuElement previousMenuElement;
    private MenuElement menuElementAfterSuccessfulLogin;

    @Override
    public void handleMenuInteraction() {
        login();
    }

    private void login() {
        System.out.println("Please give me your username: ");
        String username = Util.readUserInput();
        System.out.println("Please give me your password: ");
        String password = Util.readUserInput();
        handleLoginInputs(username, password);
    }

    private void handleLoginInputs(String username, String password) {
       loginService.searchUserByNameAndPassword(username, password)
                .ifPresentOrElse(
                        (appManagerUser) -> {
                            System.out.println("Welcome " + username + "!");
                            loginService.afterSuccessfulLogin(appManagerUser);
                        },
                        () -> {
                            System.out.println("Your username or password is not correct.");
                            previousMenuElement.handleMenuInteraction();
                        });
    }

    @Override
    public String getMenuElementName() {
        return menuElementName;
    }
}
