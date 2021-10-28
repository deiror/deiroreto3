
package com.deiro.grupo11.service;

import com.deiro.grupo11.dao.ClientRepository;
import com.deiro.grupo11.entities.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alex
 */
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    public List<Client> getAll() {return (List<Client>) clientRepository.getAll();};
  
  public Optional<Client> getClient(int id) {return clientRepository.getClient(id);};
  
  public Client save(Client client) { 
       if (client.getIdClient()== null){
           return clientRepository.save(client);
       }
       else
       {
          Optional<Client> co =  clientRepository.getClient(client.getIdClient());
          if (co.isEmpty()){
              return clientRepository.save(client);
          }
          else
          {
              return client;
          }
       }
 
    }

    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client>co=clientRepository.getClient(client.getIdClient());
            if(!co.isEmpty()){
                if(client.getEmail()!=null){
                    co.get().setEmail(client.getEmail());
                }
                if(client.getName()!=null){
                    co.get().setName(client.getName());
                }
                
                if(client.getAge()!=null){
                    co.get().setAge(client.getAge());
                }
                
                if(client.getPassword()!=null){
                    co.get().setPassword(client.getPassword());
                }
                
                return clientRepository.save(co.get());
            }
        }
        return client;
    }
   
   public boolean deleteClient(int idClient) { 
       Optional<Client> co =  clientRepository.getClient(idClient);
       if (co.isEmpty()){
           return false;
       }
       else
       {
        clientRepository.delete(co.get());
        return true;
       }
   }
    
}
