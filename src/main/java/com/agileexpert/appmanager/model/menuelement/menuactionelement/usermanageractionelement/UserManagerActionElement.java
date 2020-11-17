package com.agileexpert.appmanager.model.menuelement.menuactionelement.usermanageractionelement;

import com.agileexpert.appmanager.model.menuelement.menuactionelement.MenuActionElement;
import com.agileexpert.appmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class UserManagerActionElement extends MenuActionElement {

    @Autowired
    protected UserService userService;

}
