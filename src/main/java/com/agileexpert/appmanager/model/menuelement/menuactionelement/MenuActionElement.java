package com.agileexpert.appmanager.model.menuelement.menuactionelement;

import lombok.Data;

@Data
public abstract class MenuActionElement {

    private String actionElementName;

    public abstract void handleAction();
}
