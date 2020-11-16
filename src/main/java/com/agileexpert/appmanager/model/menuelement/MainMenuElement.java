package com.agileexpert.appmanager.model.menuelement;

import org.springframework.stereotype.Component;

@Component
public class MainMenuElement extends MenuElement {

    public MainMenuElement() {
        this.setElementName("Main menu");
    }

    @Override
    protected void showContent() {
        if(subMenuElements.size() > 0) {
            System.out.println("Please chose from the option(s): ");
            for (MenuElement menuElement : subMenuElements) {
                System.out.println(menuElement.getElementName() + "\n");
            }
        } else {
            System.out.println("(0) Back to " + previousMenuElement.getElementName());
        }
    }
}
