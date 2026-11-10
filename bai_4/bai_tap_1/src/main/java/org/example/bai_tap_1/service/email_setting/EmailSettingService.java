package org.example.bai_tap_1.service.email_setting;

import org.example.bai_tap_1.enity.EmailSettings;
import org.springframework.stereotype.Service;

@Service
public class EmailSettingService implements IEmailSettingService {
    private static EmailSettings emailSettings;

    static {
        emailSettings = new EmailSettings("en", 25, false, "Thor\n\nKing, Asgard");
    }


    @Override
    public EmailSettings getEmailSettings() {
        return emailSettings;
    }

    @Override
    public boolean saveEmailSettings(EmailSettings emailSetting) {
        emailSettings = emailSetting;
        return true;
    }
}
