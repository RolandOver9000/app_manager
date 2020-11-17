package com.agileexpert.appmanager.model.menuelement.menunavigationelement;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Data
@Service
@RequiredArgsConstructor
public class UserManager implements MenuNavigationElement {

    private String elementName;

    private Map<String, MenuElement> menuActionElements;
    private Integer menuOptionCounter = 0;


    @Override
    public void showContent() {
        System.out.println("Please, write down the number of the chosen menu: ");
        for (String menuActionKey : menuActionElements.keySet()) {
            System.out.println("(" + menuActionKey + ") " +
                    menuActionElements.get(menuActionKey).getElementName() + "\n");
        }


    }

    @Override
    public void handleAction() {

    }

    public void addMenuActionElement(MenuElement menuElement) {
        menuActionElements.put(menuOptionCounter.toString(), menuElement);
    }


}
