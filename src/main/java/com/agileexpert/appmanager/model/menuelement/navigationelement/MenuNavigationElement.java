package com.agileexpert.appmanager.model.menuelement.navigationelement;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.service.util.Util;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class MenuNavigationElement implements NavigationElement {

    private String menuElementName;
    private Map<String, MenuElement> menuElements;
    protected MenuElement previousMenuNavigationElement;

    @Override
    public void handleMenuInteraction() {
        displayContent();
        handleAction();
    }

    @Override
    public void displayContent() {
        Util.clearScreen();
        System.out.println("Your are in the " + menuElementName + "\n");
        for (String menuActionKey : menuElements.keySet()) {
            System.out.println("(" + menuActionKey + ") " +
                    menuElements.get(menuActionKey).getMenuElementName());
        }
        if(previousMenuNavigationElement != null) {
            System.out.println("\n For previous menu please enter 0.");
        }
    }

    public void handleAction() {
        String userInput = "";
        while(!Util.isInputValidNumber(userInput) ||
                !isInputChoosableOption(userInput)) {
            System.out.println("Please, write down the number of the chosen menu: ");
            userInput = Util.readUserInput();
        }
        if (userInput.equals("0")) {
            previousMenuNavigationElement.handleMenuInteraction();
        } else {
            menuElements.get(userInput).handleMenuInteraction();
        }

    }

    private boolean isInputChoosableOption(String input) {
        return menuElements.containsKey(input);
    }

    @Override
    public void linkMenuElement(MenuElement menuElement) {
        int menuElementsSize = menuElements.keySet().size();
        menuElements.put(Integer.toString(menuElementsSize), menuElement);
    }
}
