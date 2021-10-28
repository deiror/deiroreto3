/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deiro.grupo11.dao;

import com.deiro.grupo11.entities.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.deiro.grupo11.entities.CategoryCrudInterface;


@Repository
public class CategoryRepository {
  @Autowired
  private CategoryCrudInterface categoryCrudRepository;
  
  public List<Category> getAll() {return (List<Category>) categoryCrudRepository.findAll();};
  
  public Optional<Category> getCategory(int id) {return categoryCrudRepository.findById(id);};
  
  public Category save(Category category) {return categoryCrudRepository.save(category);};
  
  public void delete(Category category) {categoryCrudRepository.delete(category);};
  
     
}