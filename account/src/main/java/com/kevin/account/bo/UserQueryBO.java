package com.kevin.account.bo;
/**
 * @Author:Kevin
 * @Date:Created in 7:49 2021/4/24
 */
public class UserQueryBO{
    private String phone;
    private String firstName;
    private String lastName;

    public UserQueryBO() {
    }

    public UserQueryBO(String phone, String firstName, String lastName) {
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

