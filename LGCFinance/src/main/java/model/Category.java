/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author gustavoavelar
 */
public class Category implements BaseModel {

    private Long id;
    
    private String name;
    
    private List<Transaction> payments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transaction> getPayments() {
        return payments;
    }

    public void setPayments(List<Transaction> payments) {
        this.payments = payments;
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
    
}
