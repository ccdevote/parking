package com.parking.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connections {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DriverManager manager = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking", "info", "");
    }
    public static Connection getConnection() {
    }
}
