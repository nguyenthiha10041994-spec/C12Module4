package com.example.ss4_bai1.service;

import com.example.ss4_bai1.model.EmailSetting;
import com.example.ss4_bai1.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private IEmailRepository repository;

    @Override
    public EmailSetting getSetting() {
        return repository.getSetting();
    }

    @Override
    public void update(EmailSetting setting) {
        repository.update(setting);
    }
}