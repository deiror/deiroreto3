
package com.deiro.grupo11.service;

import com.deiro.grupo11.dao.MessageTextRepository;
import com.deiro.grupo11.entities.MessageText;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageTextService {
    @Autowired
    MessageTextRepository messageTextRepository ;
    
     public List<MessageText> getAll() {return (List<MessageText>) messageTextRepository.getAll();};
  
  public Optional<MessageText> getMessageText(int id) {return messageTextRepository.getMessageText(id);};
  
  public MessageText save(MessageText messageText) { 
       if (messageText.getIdMessage()== null){
           return messageTextRepository.save(messageText);
       }
       else
       {
          Optional<MessageText> co =  messageTextRepository.getMessageText(messageText.getIdMessage());
          if (co.isEmpty()){
              return messageTextRepository.save(messageText);
          }
          else
          {
              return messageText;
          }
       }
 
    }

   public MessageText update(MessageText messageText){
        if(messageText.getIdMessage()!=null){
            Optional<MessageText>co=messageTextRepository.getMessageText(messageText.getIdMessage());
            if(!co.isEmpty()){
                if(messageText.getMessageText()!=null){
                    co.get().setMessageText(messageText.getMessageText());
                }
                             
                return messageTextRepository.save(co.get());
            }
        }
        return messageText;
    }
   
   public boolean deleteMessage(int idMessage) { 
       Optional<MessageText> co =  messageTextRepository.getMessageText(idMessage);
       if (co.isEmpty()){
           return false;
       }
       else
       {
        messageTextRepository.delete(co.get());
        return true;
       }
   }
     
    
    
    
}
