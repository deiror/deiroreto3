
package com.deiro.grupo11.service;

import com.deiro.grupo11.dao.ReservationRepository;
import com.deiro.grupo11.entities.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
     public List<Reservation> getAll() {return (List<Reservation>) reservationRepository.getAll();};
  
  public Optional<Reservation> getReservation(int id) {return reservationRepository.getReservation(id);};
  
  public Reservation save(Reservation reservation) { 
       if (reservation.getIdReservation()== null){
           return reservationRepository.save(reservation);
       }
       else
       {
          Optional<Reservation> co =  reservationRepository.getReservation(reservation.getIdReservation());
          if (co.isEmpty()){
              return reservationRepository.save(reservation);
          }
          else
          {
              return reservation;
          }
       }
 
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation>co=reservationRepository.getReservation(reservation.getIdReservation());
            if(!co.isEmpty()){
                if(reservation.getStatus()!=null){
                    co.get().setStatus(reservation.getStatus());
                }
                             
                return reservationRepository.save(co.get());
            }
        }
        return reservation;
    }
   
   public boolean deleteReservation(int idMessage) { 
       Optional<Reservation> co =  reservationRepository.getReservation(idMessage);
       if (co.isEmpty()){
           return false;
       }
       else
       {
        reservationRepository.delete(co.get());
        return true;
       }
   }
  
  
  
  
    
}
