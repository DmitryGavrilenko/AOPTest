package com.condatabase.aopconfig;

import com.condatabase.User;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
public class MyLogger {

    Logger log  = Logger.getLogger(MyLogger.class.getName());

    @AfterReturning("execution(* com.condatabase.DatabaseConnect.getAll(..))")
    public void getAllLog(){
        log.log(Level.INFO, "Get all from table users");
    }


}
