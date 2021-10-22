package com.deiro.grupo11.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author DEIRO
 */
@Entity
@Table (name="motorbike")
public class Motorbike  implements Serializable { // public class Motorbike implements Serializable
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    	private Integer id;
        private String name;
        private String brand;
        private Integer year;
        private String description;
       
//     
        @ManyToOne
        @JoinColumn(name = "categoryId")  //categoryId   como se va a llamar esa lave foranea
        @JsonIgnoreProperties("motorbikes") //"motorbikes"Tener en cuenta por ciclos repetitivosESTE ES EL CAMPO QUE DEBE IGNORA
        private Category category;//Este es el campo que me almacena la categoriaLA MOTOCICLETA TIENE UN ATRIBUTO QUE SE LLAMA category
  
       
     //@JsonIgnoreProperties("category")
     @OneToMany(cascade = {javax.persistence.CascadeType.PERSIST},mappedBy="motorbike")//Este campo debe coincidir con el nombre con el que se almaceno
     @JsonIgnoreProperties({"motorbike","client"})//@JsonIgnoreProperties("motorbikes")
     public List<MessageText> messages ;
//     
     
     @OneToMany(cascade = {javax.persistence.CascadeType.PERSIST},mappedBy="motorbike")//Este campo debe coincidir con el nombre con el que se almaceno
     @JsonIgnoreProperties({"motorbike","messages"})// @JsonIgnoreProperties("motorbikes")
     public List<Reservation> reservations ;
// 
        

 //========================================================================

//=======================================================================

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
//
    public List<MessageText> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageText> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
         
}//fin



