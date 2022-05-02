package ru.fedorov.exam.service.impl;

import org.springframework.stereotype.Service;
import ru.fedorov.exam.api.response.SettingsResponse;
import ru.fedorov.exam.service.SettingsService;

@Service
public class SettingsServiceImpl implements SettingsService {

    @Override
    public SettingsResponse getGlobalSettings() {
        SettingsResponse settingsResponse = new SettingsResponse();
        settingsResponse.setMultiuserMode(true);
        settingsResponse.setPostPremoderation(true);
        return settingsResponse;
    }

}
