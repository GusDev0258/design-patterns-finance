/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;
import model.Category;
/**
 *
 * @author sonho
 */
public class CategoryFactory implements ModelFactory{
    public Category create(String name) {
        var category = new Category();
        category.setId(this.generateId());
        category.setName(name);
        return category;
    }
}
