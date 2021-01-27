/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraison.beans;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import livraison.dto.OrderDTO;

/**
 *
 * @author attuku
 */
@MessageDriven(activationConfig={
    @ActivationConfigProperty(propertyName="acknowledgeMode", propertyValue="Auto-acknowledge"),
    @ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
    @ActivationConfigProperty(propertyName="destinationLookup", propertyValue="jms/OrderAuctionQueue"),    
})
public class OrderMDB implements MessageListener{
    @EJB
    LivraisonService livraisonService;
    
    @Resource
    private MessageDrivenContext context;
    
    @Override
    public void onMessage(Message message) {
        try {
            OrderDTO order = message.getBody(OrderDTO.class);
            livraisonService.add(order);
        }catch(JMSException jmse){
            jmse.printStackTrace();
            context.setRollbackOnly();
        }
    }
    
}
