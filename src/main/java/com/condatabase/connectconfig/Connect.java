package com.condatabase.connectconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

@Configuration
@ComponentScan(basePackages = "com.condatabase")
public class Connect {

    private final String URL = "jdbc:mysql://localhost:3306/test";
    private final String USER_NAME = "root";
    private final String PASSWORD = "root";


    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER_NAME, PASSWORD);
    }

    @Bean
    public ArrayList getUserList(){
        return new ArrayList<>();
    }
}
