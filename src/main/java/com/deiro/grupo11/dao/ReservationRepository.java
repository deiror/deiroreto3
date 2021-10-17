
package com.deiro.grupo11.dao;

import com.deiro.grupo11.entities.Reservation;
import com.deiro.grupo11.entities.ReservationCrudInterface;
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
    

}
