package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuElement currentElement;

    public void showMenu() {
        currentElement.showContent();
    }

}
