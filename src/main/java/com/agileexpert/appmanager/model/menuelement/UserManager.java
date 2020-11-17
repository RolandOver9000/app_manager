package com.agileexpert.appmanager.model.menuelement;

import com.agileexpert.appmanager.model.menuelement.menuactionelement.MenuActionElement;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Data
@Service
@RequiredArgsConstructor
public class UserManager implements MenuElement{

    private String elementName;
    private Set<MenuActionElement> menuActionElements;


    @Override
    public void showContent() {
        System.out.println();
    }

    @Override
    public void handleMenuAction() {

    }
}
