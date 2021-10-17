/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deiro.grupo11.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable; //
import java.util.List;
import javax.persistence.Entity;//
import javax.persistence.GeneratedValue;//
import javax.persistence.GenerationType;//
import javax.persistence.Id;//
import javax.persistence.OneToMany;
import javax.persistence.Table;//
import org.hibernate.annotations.CascadeType;//


@Entity
@Table(name="category")
public class Category implements Serializable {
        @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
        private String name;
        private String description;
              
     
     @JsonIgnoreProperties("category")
     @OneToMany(cascade = {javax.persistence.CascadeType.PERSIST},mappedBy="category")//Este campo debe coincidir con el nombre con el que se almaceno
     public List<Motorbike> motorbikes ;
    
     
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Motorbike> getMotorbikes() {
        return motorbikes;
    }

    public void setMotorbikes(List<Motorbike> motorbikes) {
        this.motorbikes = motorbikes;
    }

       
     
    }