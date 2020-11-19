package com.agileexpert.appmanager.model.menuelement.actionelement.icon;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.service.ConsoleSettingsService;
import com.agileexpert.appmanager.service.util.Util;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class DeleteIcon implements MenuElement{

    private String menuElementName = "Delete icon";
    private final ConsoleSettingsService consoleSettingsService;
    private MenuElement previousMenuElement;


    @Override
    public void handleMenuInteraction() {
        deleteIcon();
    }

    private void deleteIcon() {
        String userAnswer = "";
        while(!isUserAnswerValid(userAnswer)) {
            System.out.println("Are you sure you want to delete your icon? ((y)es / (n)o");
            userAnswer = Util.readUserInput();
            if (userAnswer.equals("y")) {
                consoleSettingsService.removeCurrentUserIcon();
                System.out.println("Your icon removed.");
            }
            if (userAnswer.equals("n")) {
                previousMenuElement.handleMenuInteraction();
            }
        }
    }

    private boolean isUserAnswerValid(String userAnswer) {
        return userAnswer.equals("y") || userAnswer.equals("n");
    }


}
