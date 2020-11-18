package com.agileexpert.appmanager.model.menuelement.navigationelement;

import com.agileexpert.appmanager.model.menuelement.MenuElement;

public interface NavigationElement extends MenuElement {
    void displayContent();
    void linkMenuElement(MenuElement menuElement);
}
