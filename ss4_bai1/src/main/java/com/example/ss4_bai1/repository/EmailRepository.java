package com.example.ss4_bai1.repository;

import com.example.ss4_bai1.model.EmailSetting;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepository implements IEmailRepository {

    private EmailSetting setting =
            new EmailSetting(
                    "English",
                    25,
                    true,
                    "Thor\nKing, Asgard"
            );

    @Override
    public EmailSetting getSetting() {
        return setting;
    }

    @Override
    public void update(EmailSetting setting) {
        this.setting = setting;
    }
}