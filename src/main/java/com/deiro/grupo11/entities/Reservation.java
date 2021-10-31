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
import javax.persistence.Temporal;

@Entity
@Table(name="reservation")
public class Reservation implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    //@Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    //@Temporal(javax.persistence.TemporalType.DATE)
    private Date devolutionDate;
    private String status="created";
         
        @ManyToOne
        @JoinColumn(name = "reservationId" )  //   "reservationId" categoryId   como se va a llamar esa lave foranea
        @JsonIgnoreProperties("reservations") //Tener en cuenta por ciclos repetitivosESTE ES EL CAMPO QUE DEBE IGNORAR
        private Motorbike motorbike;
       
       @ManyToOne
       @JoinColumn(name = "clientId")
       @JsonIgnoreProperties({"reservations","messages"})//----------{"reservations","messages"}
       private Client client;
       private String score;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
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
