package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.model.menuelement.MenuNavigationElement;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private MenuNavigationElement currentElement;

    public void startMenu() {
        initializeMenuElements();
    }

    private void initializeMenuElements() {

    }

    public void showMenu() {
        currentElement.showContent();
    }

}
