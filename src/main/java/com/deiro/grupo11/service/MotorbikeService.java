
package com.deiro.grupo11.service;

import com.deiro.grupo11.dao.MotorbikeRepository;
import com.deiro.grupo11.entities.Motorbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MotorbikeService {
    @Autowired
    MotorbikeRepository motorbikeRepository;//-------------private al inicio
    
  public List<Motorbike> getAll() {return (List<Motorbike>) motorbikeRepository.getAll();};
  
  public Optional<Motorbike> getMotorbike(int id) {return motorbikeRepository.getMotorbike(id);};
  
  public Motorbike save(Motorbike motorbike) {
        if (motorbike.getId() == null) {
            return motorbikeRepository.save(motorbike);
        } else {
            Optional<Motorbike> co = motorbikeRepository.getMotorbike(motorbike.getId());
            if (co.isEmpty()) {
                return motorbikeRepository.save(motorbike);
            } else {
                return motorbike;
            }
        }

    }
  
  public Motorbike update(Motorbike motorbike){
        if(motorbike.getId()!=null){
            Optional<Motorbike>co=motorbikeRepository.getMotorbike(motorbike.getId());
            if(!co.isEmpty()){
                if(motorbike.getDescription()!=null){
                    co.get().setDescription(motorbike.getDescription());
                }
                if(motorbike.getName()!=null){
                    co.get().setName(motorbike.getName());
                }
                
                if(motorbike.getBrand()!=null){
                    co.get().setBrand(motorbike.getBrand());
                }
                
                if(motorbike.getYear()!=null){
                    co.get().setYear(motorbike.getYear());
                }
                
                return motorbikeRepository.save(co.get());
            }
        }
        return motorbike;
    }
   
   public boolean deleteMotorbike(int id) { 
       Optional<Motorbike> co =  motorbikeRepository.getMotorbike(id);
       if (co.isEmpty()){
           return false;
       }
       else
       {
        motorbikeRepository.delete(co.get());
        return true;
       }
   }
  
  
}
