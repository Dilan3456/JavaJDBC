package com.alura.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreaConexion {
    public Connection ConnectionRecovery() throws SQLException {

        return  DriverManager.getConnection("jdbc:mysql://localhost/control_de_stock?useTimeZone=true&ServerTimeZone=UTC", "root", "passw0rd");
    }
}
