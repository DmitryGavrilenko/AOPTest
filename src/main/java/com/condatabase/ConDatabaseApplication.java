package com.condatabase;

import com.condatabase.aopconfig.MyLogger;
import com.condatabase.connectconfig.Connect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class ConDatabaseApplication {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Connect.class);

        DatabaseConnect databaseConnect = (DatabaseConnect) context.getBean("databaseConnect");

        try {

            databaseConnect.getAll().stream().forEach(n -> System.out.println(n));

        }catch (SQLException exc){
            System.out.println(exc);
        }
    }
}
