
package com.deiro.grupo11.service;

import com.deiro.grupo11.entities.Reservation;
import java.text.ParseException;
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
@RequestMapping("/api/Reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")
      public List<Reservation> getReservations() {return reservationService.getAll();};

    @GetMapping("/{id}")
      public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
          return reservationService.getReservation(reservationId);
      }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
      public Reservation save(@RequestBody Reservation reservation) {return reservationService.save(reservation);};
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {return reservationService.update(reservation);};
      
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int reservationId) {reservationService.deleteReservation(reservationId);};
    
    //ADICONAR AL RETO 5
     @GetMapping("/report-status")
    public StatusReservas getReservas(){
        return reservationService.getReporteStatusReservaciones();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo) throws ParseException{
        return reservationService.getReportesTiempoReservaciones(dateOne, dateTwo);
    }
    
    @GetMapping("/report-clients")
    public List<ContadorClientes> getClientes(){
        return reservationService.servicioTopClientes();
    
    }
    
    
}
