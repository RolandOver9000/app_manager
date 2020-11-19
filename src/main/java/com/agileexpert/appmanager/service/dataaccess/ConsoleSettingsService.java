package com.agileexpert.appmanager.service.dataaccess;

import com.agileexpert.appmanager.model.AppManagerUser;
import com.agileexpert.appmanager.model.ConsoleSettings;
import com.agileexpert.appmanager.repository.ConsoleSettingsRepository;
import com.agileexpert.appmanager.service.AppManagerContext;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
@RequiredArgsConstructor
@Slf4j
public class ConsoleSettingsService {

    private final AppManagerContext appManagerContext;
    private final ConsoleSettingsRepository consoleSettingsRepository;
    private static String STANDARD_BACKGROUND_COLOR = "black";
    private static String STANDARD_ICON = "~";

    public void setConsoleSettingsForRegisteredUser(AppManagerUser newAppManagerUser) {
         ConsoleSettings newConsoleSettings = ConsoleSettings.builder()
                 .consoleBackgroundColor(STANDARD_BACKGROUND_COLOR)
                 .icon(STANDARD_ICON)
                 .appManagerUser(newAppManagerUser)
                 .build();
        consoleSettingsRepository.save(newConsoleSettings);


    }

    public boolean trySetNewIcon(String newIcon) {
        ConsoleSettings searchedSettings = getCurrentConsoleSettings();
        if(searchedSettings != null) {
            searchedSettings.setIcon(newIcon);
            consoleSettingsRepository.save(searchedSettings);
            refreshAppManagerContextCurrentConsoleSettings(searchedSettings);
            return true;
        }
        return false;
    }

    private void refreshAppManagerContextCurrentConsoleSettings(ConsoleSettings currentConsoleSettings) {
        appManagerContext.setCurrentConsoleSettings(currentConsoleSettings);
    }

    public void removeCurrentUserIcon() {
        ConsoleSettings searchedConsoleSettings = getCurrentConsoleSettings();
        searchedConsoleSettings.setIcon("");
        consoleSettingsRepository.save(searchedConsoleSettings);
        refreshAppManagerContextCurrentConsoleSettings(searchedConsoleSettings);
    }

    private ConsoleSettings getCurrentConsoleSettings() {
        Optional<ConsoleSettings> currentConsoleSettings = consoleSettingsRepository
                .getConsoleSettingsByAppManagerUser(appManagerContext.getCurrentAppManagerUser());
        return currentConsoleSettings.orElse(null);
    }
}
