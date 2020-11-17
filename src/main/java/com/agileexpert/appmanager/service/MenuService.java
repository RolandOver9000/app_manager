package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.model.menuelement.menunavigationelement.OldMenuNavigationElement;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private OldMenuNavigationElement currentElement;

    public void startMenu() {
        initializeMenuElements();
    }

    private void initializeMenuElements() {

    }

    public void showMenu() {
        currentElement.showContent();
    }

}
