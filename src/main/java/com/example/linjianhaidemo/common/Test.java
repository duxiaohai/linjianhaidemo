package com.example.linjianhaidemo.common;

import com.example.linjianhaidemo.domain.User;

public class Test {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("张三");
        user.setAge("20");
        user.setIdCard("2233");

        User user1 = new User();
        user1.setUserName("张三");
        user1.setAge("20");
        user1.setIdCard("2233");

        String aa = "cc";
        System.out.println(aa.equals("cc"));

      System.out.println(user.equals(user1));
    }


    public String kk(){

        return "";
    }
}
