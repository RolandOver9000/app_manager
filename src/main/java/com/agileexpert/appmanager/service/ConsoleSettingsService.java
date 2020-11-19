package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.model.ConsoleSettings;
import com.agileexpert.appmanager.repository.ConsoleSettingsRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
@Slf4j
public class ConsoleSettingsService {

    private final ConsoleSettingsRepository consoleSettingsRepository;
    private static String STANDARD_BACKGROUND_COLOR = "black";
    private static String STANDARD_ICON = "~";

    public ConsoleSettings getNewConsoleSettingsObject() {
        return ConsoleSettings.builder()
                .consoleBackgroundColor(STANDARD_BACKGROUND_COLOR)
                .icon(STANDARD_ICON)
                .build();
    }
}
