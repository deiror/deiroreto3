
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
       if (reservation.getId()== null){
           return reservationRepository.save(reservation);
       }
       else
       {
          Optional<Reservation> co =  reservationRepository.getReservation(reservation.getId());
          if (co.isEmpty()){
              return reservationRepository.save(reservation);
          }
          else
          {
              return reservation;
          }
       }
 
    }
    
    
    
}
