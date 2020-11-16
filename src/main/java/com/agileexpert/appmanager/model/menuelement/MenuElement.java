package com.agileexpert.appmanager.model.menuelement;

import lombok.Data;

import java.util.Set;

@Data
public abstract class MenuElement {

    private String elementName;
    protected Set<MenuElement> subMenuElements;
    protected MenuElement previousMenuElement;

    public abstract void showContent();

}
