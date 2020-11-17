package com.agileexpert.appmanager.model.menuelement;

import lombok.Data;

import java.util.Set;

@Data
public class MenuNavigationElement implements MenuElement {

    private String elementName;
    protected Set<MenuElement> subMenuElements;
    protected MenuNavigationElement previousMenuNavigationElement;

    public void showContent() {
        System.out.println("Please, write down the number of the chosen menu: ");
        for (MenuElement subMenuElement : subMenuElements) {
            System.out.println(subMenuElement.getElementName() + "\n");
        }

    };

    @Override
    public void handleMenuAction() {

    }
}
