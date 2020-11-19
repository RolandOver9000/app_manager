package com.agileexpert.appmanager.model.menuelement.actionelement.icon;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.service.util.Util;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class AddIcon implements MenuElement {

    private String menuElementName = "Add user";

    @Override
    public void handleMenuInteraction() {
        addIcon();
    }

    private void addIcon() {
        System.out.println("Please enter the chosen icon.");
        String newIcon = Util.readUserInput();

    }
}
