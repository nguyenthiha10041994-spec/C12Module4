package com.example.ss8_validate_form.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class User {

    @NotBlank(message = "Firstname không được để trống")
    @Size(min = 5, max = 45, message = "Firstname phải từ 5 đến 45 ký tự")
    private String firstname;
    @NotBlank(message = "Lastname không được để trống")
    @Size(min = 5, max = 45, message = "Lastname phải từ 5 đến 45 ký tự")
    private String lastname;
    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(
            regexp = "^0[0-9]{9}$",
            message = "Số điện thoại phải có 10 chữ số và bắt đầu bằng 0"
    )
    private String phoneNumber;
    @Min(value = 18, message = "Tuổi phải từ 18 trở lên")
    private int age;
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;
    public User() {
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}