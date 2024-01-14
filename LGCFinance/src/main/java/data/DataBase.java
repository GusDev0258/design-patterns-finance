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
public final class DataBase {
    private Connection connection = null;
    private static final DataBase instance = new DataBase();
    
    private DataBase(){}
    
    public static DataBase getInstance() { 
        return instance;
    }
    
    public void initConnection(String url, String username, String password) throws SQLException, Exception{
        if(this.connection == null) {
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected");
        }else{
            throw new Exception("You are already connected, close your connection before starting a new one");
        }
    }
    
    public void closeConnection() throws Exception {
        if (this.connection != null) {
            this.connection.close();
            this.connection = null;
            System.out.println("Connection ended");
        } else {
            throw new Exception("A connection must be started before ending");
        }
    }
    
    public Connection getConnection() {
        return this.connection;
    }
}
