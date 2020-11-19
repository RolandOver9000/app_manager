package com.agileexpert.appmanager.model.menuelement.actionelement.application;

import com.agileexpert.appmanager.model.Application;
import com.agileexpert.appmanager.model.menuelement.MenuElement;
import com.agileexpert.appmanager.service.dataaccess.ApplicationService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Data
@Component
@RequiredArgsConstructor
public class InstalledApplications implements MenuElement {

    private final ApplicationService applicationService;
    private String menuElementName = "Installed applications";
    private MenuElement previousMenuElement;

    @Override
    public void handleMenuInteraction() {
        showInstalledApplications();
    }

    private void showInstalledApplications() {
        Set<Application> installedApplications = applicationService.getInstalledApplications();
    }

    @Override
    public String getMenuElementName() {
        return null;
    }
}
