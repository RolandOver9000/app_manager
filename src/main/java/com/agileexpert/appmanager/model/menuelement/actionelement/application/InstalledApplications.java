package com.agileexpert.appmanager.model.menuelement.actionelement.application;

import com.agileexpert.appmanager.model.Application;
import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.service.dataaccess.ApplicationService;
import com.agileexpert.appmanager.service.util.Util;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Data
@Component
@RequiredArgsConstructor
public class InstalledApplications implements MenuElement {

    private final ApplicationService applicationService;
    private String menuElementName = "Installed applications";
    private List<Application> installedApplications;
    private MenuElement previousMenuElement;

    @Override
    public void handleMenuInteraction() {
        showInstalledApplications();
        handleAction();
    }

    private void showInstalledApplications() {
        installedApplications = applicationService.getInstalledApplications();
        if(installedApplications.size() > 0) {
            System.out.println("These are your installed applications: ");
            for(int index = 0; index < installedApplications.size(); index++) {
                System.out.println("(" + index + ") " +
                        installedApplications.get(index).getApplicationName());
            }
            if(previousMenuElement != null) {
                System.out.println("\n For previous menu please enter 0.");
            }
        }
    }

    public void handleAction() {
        String userInput = "";
        while(!Util.isInputValidNumber(userInput) ||
                !isInputChoosableOption(Integer.parseInt(userInput))) {
            System.out.println("Please, enter the number of the chosen menu: ");
            userInput = Util.readUserInput();
        }
        if (userInput.equals("0")) {
            previousMenuElement.handleMenuInteraction();
        } else {
            String chosenApplicationName =
                    installedApplications.get(Integer.parseInt(userInput)).getApplicationName();
            System.out.println(chosenApplicationName + " is running.");
        }
        previousMenuElement.handleMenuInteraction();

    }

    private boolean isInputChoosableOption(Integer input) {
        return (installedApplications.size() > input && 0 < input) || input.equals("0");
    }

    @Override
    public String getMenuElementName() {
        return menuElementName;
    }
}
