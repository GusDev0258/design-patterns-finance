/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observer;

import java.util.List;
import model.Category;
/**
 *
 * @author sonho
 */
public interface CategoryListObserver {
    public void updateCategoryList(List<Category> categories);
}
