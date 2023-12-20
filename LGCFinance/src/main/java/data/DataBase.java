/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gustavoavelar
 */
public class DataBase {
    private Connection connection = null;
    
    private void InitConnection(String url, String username, String password) throws SQLException{
        this.connection = DriverManager.getConnection(url, username, password);
    }
    private void CloseConnection() throws Exception{
        if(this.connection == null) {
            throw new Exception("A connection must be start before ending");
        }
        this.connection.close();
    }
}
