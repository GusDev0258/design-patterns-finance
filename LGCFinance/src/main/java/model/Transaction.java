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
    public void setId(Long id);
    public void setName(String name);
    public void setCategory(Category category);
    public void setValue(Double value);
    public void setDate(LocalDate date);
    public void setDescription(String descrpition) ;
    public void setOrigin(String origin);
    public void setAuthor(Author author);
    public void setInvoice(Invoice invoice);
    public Invoice getInvoice();

}
