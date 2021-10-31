package com.deiro.grupo11.service;

import com.deiro.grupo11.dao.ReservationRepository;
import com.deiro.grupo11.entities.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author DEIRO ROSALES
 */
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
      
   //ADICIONAR AL RETO 5
   
   public StatusReservas getReporteStatusReservaciones(){
        List<Reservation>completed= reservationRepository.ReservacionStatus("completed");
        List<Reservation>cancelled= reservationRepository.ReservacionStatus("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());
    }
    
    public List<Reservation> getReportesTiempoReservaciones(String datoA, String datoB){ 
        SimpleDateFormat parser=new SimpleDateFormat ("yyyy-MM-dd");//yyyy-MM-dd'T'HH:mm:ss.SSSZ T00:00:00.000+00:00
        //SimpleDateFormat parser=new SimpleDateFormat ("yyyy-MM-dd");//yyyy-MM-dd'T'HH:mm:ss.SSSZ T00:00:00.000+00:00

        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservationRepository.ReservacionTiempo(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }
    }  
    
    public List<ContadorClientes> servicioTopClientes(){
        return reservationRepository.getTopClientes();
    }
   
}
