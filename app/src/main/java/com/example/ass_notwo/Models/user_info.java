package com.example.ass_notwo.Models;

public class user_info {

   private String name ;
   private String address;
   private String email ;
   private String phone_num ;
   private String hobbies ;
   private String gender ;
   private String major ;
   private String education ;
   private String no_of_exp ;

    public user_info() {}

    public user_info(String name, String address, String email, String phone_num, String hobbies, String gender, String major, String education, String no_of_exp) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone_num = phone_num;
        this.hobbies = hobbies;
        this.gender = gender;
        this.major = major;
        this.education = education;
        this.no_of_exp = no_of_exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getNo_of_exp() {
        return no_of_exp;
    }

    public void setNo_of_exp(String no_of_exp) {
        this.no_of_exp = no_of_exp;
    }
}
