
package com.deiro.grupo11.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation implements Serializable  {
        @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer id;
         Date startDate = new Date();
         Date devolutionDate = new Date();
         private String status = "created";
         
        
//////      @JsonIgnoreProperties("reservation")
//////      @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "reservation")
//////      //@OneToMany(cascade = {javax.persistence.CascadeType.PERSIST},mappedBy="category")
//////      public List<Motocicleta> motorbikes;
//==========================================================================
        @ManyToOne
        @JoinColumn(name = "reservationId" )  //   "reservationId" categoryId   como se va a llamar esa lave foranea
        @JsonIgnoreProperties("reservations") //Tener en cuenta por ciclos repetitivosESTE ES EL CAMPO QUE DEBE IGNORAR
        private Motorbike motorbike;
//        
//        
       @ManyToOne
       @JoinColumn(name = "clientId")
       @JsonIgnoreProperties({"reservations","messages"})//----------{"reservations","messages"}
          private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

  
    

  
       
      
//==========================================================================      

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Motorbike getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(Motorbike motorbike) {
        this.motorbike = motorbike;
    }

   

   

          
}//Fin
