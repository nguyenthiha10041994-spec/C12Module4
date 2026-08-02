package com.example.ss4_bai1.service;

import com.example.ss4_bai1.model.EmailSetting;

public interface IEmailService {

    EmailSetting getSetting();

    void update(EmailSetting setting);
}