package com.agileexpert.appmanager.model.menuelement.actionelement;

import com.agileexpert.appmanager.model.AppManagerUser;
import com.agileexpert.appmanager.model.Family;
import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.service.UserService;
import com.agileexpert.appmanager.service.util.Util;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class Registration implements MenuElement {

    private final UserService userService;
    private String menuElementName = "Registration";

    @Override
    public void handleMenuInteraction() {
        registration();
    }

    private void registration() {
        System.out.println("Please give me your username: ");
        String familyHeadUsername = Util.readUserInput();
        System.out.println("Please give me your password: ");
        String familyHeadPassword = Util.readUserInput();
        String familyHeadPasswordConfirm = "";

        while(!familyHeadPassword.equals(familyHeadPasswordConfirm)) {
            System.out.println("Please confirm your password, or enter b for exit: ");
            familyHeadPasswordConfirm = Util.readUserInput();
            if(familyHeadPasswordConfirm.equals("b")) {
                return;
            }
        }
        handleRegistrationData(familyHeadUsername, familyHeadPassword);

        System.out.println("You are now registered in the system.");
    }

    private void handleRegistrationData(String familyHeadUsername, String familyHeadPassword) {
        AppManagerUser newAppManagerUser = AppManagerUser.builder()
                .username(familyHeadUsername)
                .password(familyHeadPassword)
                .isUserFamilyHead(true)
                .build();
    }
}
