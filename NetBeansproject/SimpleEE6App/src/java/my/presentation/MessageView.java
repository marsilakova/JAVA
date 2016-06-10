/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.MessageFacade;
import entities.Message;
import static entities.Message_.message;
import java.util.Objects;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author elev10
 */
@Named(value = "MessageView")
@RequestScoped
public class MessageView {

    @EJB
    private MessageFacade messageFacade;
    private Message message;

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    
    // Returns the total number of messages
    public int getNumberOfMessages(){
       return messageFacade.findAll().size();
    }

    // Saves the message and then returns the string "theend"
    public String postMessage(){
       this.messageFacade.create(message);
       return "theend";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MessageView other = (MessageView) obj;
        if (!Objects.equals(this.messageFacade, other.messageFacade)) {
            return false;
        }
        return true;
    }

    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
    
    this.message=new Message();
    }
}

