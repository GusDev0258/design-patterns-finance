/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import model.BaseModel;

/**
 *
 * @author sonho
 */
public interface ModelFactory {
    default Long generateId() {
        var randomId = Math.random() * 1000;
        var id = String.valueOf(randomId).replace(".", "");
        return Long.parseLong(id);
    }
    
    public BaseModel create(String name);
}
