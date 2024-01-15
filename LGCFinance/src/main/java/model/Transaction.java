/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;



/**
 *
 * @author gustavoavelar
 */

public interface Transaction {

    public Long getId();
    public String getName();
    public Category getCategory();
    public Double getValue();
    public LocalDate getDate();
    public String getDescription() ;
    public String getOrigin();
    public Author getAuthor();
    public String getType() ;
}
