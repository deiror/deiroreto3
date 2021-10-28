
package com.deiro.grupo11.service;

import com.deiro.grupo11.dao.CategoryRepository;
import com.deiro.grupo11.entities.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    
  public List<Category> getAll() {return (List<Category>) categoryRepository.getAll();};
  
  public Optional<Category> getCategory(int id) {return categoryRepository.getCategory(id);};
  
  public Category save(Category category) { 
       if (category.getId()== null){
           return categoryRepository.save(category);
       }
       else
       {
          Optional<Category> co =  categoryRepository.getCategory(category.getId());
          if (co.isEmpty()){
              return categoryRepository.save(category);
          }
          else
          {
              return category;
          }
       }
 
    }
  
  public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>co=categoryRepository.getCategory(category.getId());
            if(!co.isEmpty()){
                if(category.getDescription()!=null){
                    co.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    co.get().setName(category.getName());
                }
                return categoryRepository.save(co.get());
            }
        }
        return category;
    }
   
   public boolean deleteCategory(int id) { 
       Optional<Category> co =  categoryRepository.getCategory(id);
       if (co.isEmpty()){
           return false;
       }
       else
       {
        categoryRepository.delete(co.get());
        return true;
       }
   }
   
  
}
