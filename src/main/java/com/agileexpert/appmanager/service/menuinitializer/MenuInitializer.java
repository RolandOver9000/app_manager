package com.agileexpert.appmanager.service.menuinitializer;

import com.agileexpert.appmanager.model.menuelement.navigationelement.MenuNavigationElement;
import lombok.Data;

@Data
public abstract class MenuInitializer {

    protected MenuNavigationElement menuElement;
    public abstract void initialize();
    public abstract void linkMenuElements();

}
