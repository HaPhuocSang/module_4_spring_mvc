package org.example.bai_tap_1.service.email_setting;

import org.example.bai_tap_1.enity.EmailSettings;

public interface IEmailSettingService{
    EmailSettings getEmailSettings();
    boolean saveEmailSettings(EmailSettings emailSettings);
}
