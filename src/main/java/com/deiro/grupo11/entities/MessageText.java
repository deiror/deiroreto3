
package com.deiro.grupo11.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
@Table(name="messageText")
public class MessageText implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Integer idMessage;
     private String messageText;
     
//    //@OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "")
//      //@JsonIgnoreProperties("messages")
//      @OneToMany(cascade = {javax.persistence.CascadeType.PERSIST},mappedBy="messages")//nombre con el que se creo
//      public List<Motocicleta> motorbike ;//El que se ignora
//       //@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
      
//////////////////////     @JsonIgnoreProperties("messageText")
//////////////////////     @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
//////////////////////    // @OneToMany(cascade = {javax.persistence.CascadeType.PERSIST},mappedBy="messageText")//Este campo debe coincidir con el nombre con el que se almaceno
//////////////////////     public List<Motocicleta> motorbike ;
     
  //===========================================================================   
        @ManyToOne
        @JoinColumn(name = "messageTextId")  //"messageTextId"  como se va a llamar esa lave foranea
        @JsonIgnoreProperties({"messages","reservations"}) //   {"messages"Tener en cuenta por ciclos repetitivosESTE ES EL CAMPO QUE DEBE IGNORAR
        private Motorbike motorbike;
      
       @ManyToOne
       @JoinColumn(name = "clientId")
       @JsonIgnoreProperties({"messages","reservations"})//-----
       private Client client;
       
       
//============================================================================00

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Motorbike getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(Motorbike motorbike) {
        this.motorbike = motorbike;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

  

     
    
   
}//fin


     
     

    

