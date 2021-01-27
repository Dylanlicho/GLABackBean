/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.services;

import auction.dto.OrderDTO;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;

/**
 *
 * @author attuku
 */
@Stateless
@LocalBean
public class DeliveryService {
    @Inject
    JMSContext context;
    
    @Resource(lookup = "jms/OrderAuctionQueue")
    Destination orderAuctionQueue;
    
    public void produce(OrderDTO orderDTO) {
        context.createProducer().send(orderAuctionQueue, orderDTO);
    }
}
