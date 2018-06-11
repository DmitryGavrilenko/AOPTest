package com.condatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service
public class DatabaseConnect {

    private Connection userConnection;
    private Statement userStatement;
    private ResultSet resultSet;

    private List<User> userList;

    @Autowired
    public DatabaseConnect(Connection userConnection, List userList){
        this.userConnection = userConnection;
        this.userList = userList;
    }

    public List<User> getAll() throws SQLException{

        userStatement = userConnection.createStatement();
        resultSet = userStatement.executeQuery("SELECT * FROM user ");

        while(resultSet.next()){

            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setEmail(resultSet.getString(3));
            userList.add(user);

        }

        return userList;
    }

}
