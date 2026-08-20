package com.example.ss8_validate_form.service;

import com.example.ss8_validate_form.model.User;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void save(User user) {
        System.out.println("User đã đăng ký:");
        System.out.println("Firstname: " + user.getFirstname());
        System.out.println("Lastname: " + user.getLastname());
        System.out.println("Phone: " + user.getPhoneNumber());
        System.out.println("Age: " + user.getAge());
        System.out.println("Email: " + user.getEmail());
    }
}