package ru.fedorov.exam.service;

import org.springframework.stereotype.Service;
import ru.fedorov.exam.api.response.SettingsResponse;

@Service
public class SettingsService {
    public static SettingsResponse getGlobalSettings() {
        SettingsResponse settingsResponse = new SettingsResponse();
        settingsResponse.setMultiuserMode(true);
        settingsResponse.setPostPremoderation(true);
        return settingsResponse;
    }

}
