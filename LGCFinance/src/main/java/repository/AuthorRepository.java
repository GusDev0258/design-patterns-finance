/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;

/**
 *
 * @author sonho
 */
public class AuthorRepository{
    
    Connection dbConnection;
    
    public AuthorRepository(Connection connection) {
        this.dbConnection = connection;
    }
    
}
