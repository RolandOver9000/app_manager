package com.agileexpert.appmanager.model.menuelement;

import lombok.Data;

@Data
public abstract class MenuElement {

    private String elementName;
    protected MenuElement previousMenuElement;

    protected abstract void showContent();

    protected void setPreviousMenuElement(MenuElement newPreviousMenuElement) {
        this.previousMenuElement = newPreviousMenuElement;
    };

}
