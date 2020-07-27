package com.kharitonov.text_editor.connector;

import com.kharitonov.text_editor.exception.ProjectException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlConnector {
    private static final String HOST =
            "jdbc:mysql://localhost:3306/ak2";
    private static final Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        PROPERTIES.put("user", "root");
        PROPERTIES.put("password", "admin");
        PROPERTIES.put("autoreconnect", "true");
        PROPERTIES.put("characterEncoding", "UTF-8");
        PROPERTIES.put("useUnicode", "true");
        PROPERTIES.put("serverTimezone", "UTC");
        PROPERTIES.put("verifyServerCertificate", "false");
        PROPERTIES.put("useSSL", "false");
        PROPERTIES.put("requireSSL", "false");
        PROPERTIES.put("allowPublicKeyRetrieval","true");
    }

    private SqlConnector() {
    }

    public static Connection connect() throws ProjectException {
        try {
            return DriverManager.getConnection(HOST, PROPERTIES);
        } catch (SQLException e) {
            throw new ProjectException("Unable to get connection!", e);
        }
    }
}