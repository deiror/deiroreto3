
package com.deiro.grupo11.service;

import com.deiro.grupo11.entities.Motorbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/Motorbike")

//@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MotorbikeController {
    @Autowired
    private MotorbikeService motorbikeService;
    
    @GetMapping("/all")
      public List<Motorbike> getMotorbike() {return motorbikeService.getAll();};///---Plural///---Plural///---Plural///---Plural

    @GetMapping("/{id}")                                            //int id
      public Optional<Motorbike> getMotorbike(@PathVariable("id") int motorbikeId) {
          return motorbikeService.getMotorbike(motorbikeId);
      }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
      public Motorbike save(@RequestBody Motorbike motorbike) {return motorbikeService.save(motorbike);};
      
    @PutMapping("/update")
    public Motorbike update(@RequestBody Motorbike motorbike) {return motorbikeService.update(motorbike);};
      
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int motorbikeId) {motorbikeService.deleteMotorbike(motorbikeId);}; 
}
