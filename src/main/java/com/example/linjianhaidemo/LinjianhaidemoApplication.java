package com.example.linjianhaidemo;

import aa.Testa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
public class LinjianhaidemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(LinjianhaidemoApplication.class, args);
        System.out.println("启动成功！！");
    }

}
