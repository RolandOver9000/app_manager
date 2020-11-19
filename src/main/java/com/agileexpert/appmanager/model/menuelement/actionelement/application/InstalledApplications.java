package com.agileexpert.appmanager.model.menuelement.actionelement.application;

import com.agileexpert.appmanager.model.menuelement.MenuElement;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class InstalledApplications implements MenuElement {

    private String menuElementName = "Installed applications";
    private MenuElement previousMenuElement;

    @Override
    public void handleMenuInteraction() {
        showInstalledApplications();
    }

    private void showInstalledApplications() {
    }

    @Override
    public String getMenuElementName() {
        return null;
    }
}
