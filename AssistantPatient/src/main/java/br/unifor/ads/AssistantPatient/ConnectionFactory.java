package br.unifor.ads.AssistantPatient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/AssistantPatient?useTimezone=true&serverTimezone=UTC", "root", "root");
            //jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }
}

