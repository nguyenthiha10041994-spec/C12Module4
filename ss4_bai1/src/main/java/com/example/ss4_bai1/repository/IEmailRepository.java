package com.example.ss4_bai1.repository;

import com.example.ss4_bai1.model.EmailSetting;

public interface IEmailRepository {

    EmailSetting getSetting();

    void update(EmailSetting setting);
}