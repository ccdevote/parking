package com.parking.dao;

import com.google.common.io.CharStreams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

public class Connections {
    private static final Logger LOGGER = LoggerFactory.getLogger(Collections.class);

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.error("加载数据库驱动失败.", e);
            throw new RuntimeException(e);
        }
        try {
            init();
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    public static void init() throws DaoException {
        try {
            InputStream in = Collections.class.getResourceAsStream("/init.sql");
            String initSql = CharStreams.toString(new InputStreamReader(in));
            LOGGER.info("执行数据库初始化, SQL: {}", initSql);
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            boolean isSuccess = statement.execute(initSql);
            if (!isSuccess) {
                LOGGER.error("初始数据库失败.");
            }
            LOGGER.info("数据库初始化成功");
        } catch (IOException e) {
            LOGGER.error("读取初始化SQL失败.", e);
            throw new DaoException("读取初始化SQL失败", e);
        } catch (SQLException e) {
            LOGGER.error("SQL执行失败.", e);
            throw new DaoException("SQL执行失败.", e);
        }

    }

    public static Connection getConnection() throws DaoException {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/parking", "root", "");
        } catch (SQLException e) {
            LOGGER.error("建立数据库连接失败.", e);
            throw new DaoException(e);
        }
    }
}
