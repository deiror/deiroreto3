
package com.deiro.grupo11.dao;

import com.deiro.grupo11.entities.Client;
import com.deiro.grupo11.entities.Reservation;
import com.deiro.grupo11.entities.ReservationCrudInterface;
import com.deiro.grupo11.service.ContadorClientes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    @Autowired
  private ReservationCrudInterface reservationCrudRepository;
  
  public List<Reservation> getAll() {return (List<Reservation>) reservationCrudRepository.findAll();};
  
  public Optional<Reservation> getReservation(int id) {return reservationCrudRepository.findById(id);};
  
  public Reservation save(Reservation reservation) { return reservationCrudRepository.save(reservation);};
    
 public void delete(Reservation reservation) {reservationCrudRepository.delete(reservation);};
 
 //adicionar al reto 5
 public List<Reservation> ReservacionStatus (String status){
         return reservationCrudRepository.findAllByStatus(status);
     }
     
     public List<Reservation> ReservacionTiempo (Date a, Date b){
         return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
     }
   
     public List<ContadorClientes> getTopClientes(){
         List<ContadorClientes> res=new ArrayList<>();
         List<Object[]>report = reservationCrudRepository.countTotalReservacionesByCliente();
         for(int i=0; i<report.size();i++){
             res.add(new ContadorClientes((Long)report.get(i)[1],(Client) report.get(i)[0]));
         
         }
         return res;
     }

}
