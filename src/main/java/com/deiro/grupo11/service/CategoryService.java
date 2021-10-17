
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
  
}
