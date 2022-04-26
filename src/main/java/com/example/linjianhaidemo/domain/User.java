package com.example.linjianhaidemo.domain;

import java.util.Objects;

public class User {

    private String userName;

    private String age;

    private String idCard;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(age, user.age) &&
                Objects.equals(idCard, user.idCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, age, idCard);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
