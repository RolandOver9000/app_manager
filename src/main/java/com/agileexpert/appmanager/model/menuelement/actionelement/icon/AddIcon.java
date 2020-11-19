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
public class AddIcon implements MenuElement {

    private String menuElementName = "Add icon";
    private final ConsoleSettingsService consoleSettingsService;
    private MenuElement previousMenuElement;


    @Override
    public void handleMenuInteraction() {
        addIcon();
    }

    private void addIcon() {
        System.out.println("Please enter the chosen icon.");
        String newIcon = Util.readUserInput();
        boolean isNewIconSet = consoleSettingsService.trySetNewIcon(newIcon);
        if(isNewIconSet) {
            System.out.println("Icon successfully changed to: " + newIcon);
        } else {
            System.out.println("Your icon cannot be set.");
        }
        previousMenuElement.handleMenuInteraction();
    }
}
