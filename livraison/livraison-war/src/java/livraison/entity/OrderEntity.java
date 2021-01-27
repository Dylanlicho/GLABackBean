/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraison.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import livraison.dto.OrderDTO;

/**
 *
 * @author attuku
 */
@Entity
@NamedQuery(name="OrderEntity.getAll",
            query="SELECT oe FROM OrderEntity oe Where oe.buyer = '?1'")
@Table(name="deliveries")
public class OrderEntity {
    @Id
    private int id;
    
    private int buyer;
    private String address;
    private String date;

    public OrderEntity(){}
    
    public OrderEntity(OrderDTO order) {
        this.buyer = order.getBuyer();
        this.address = order.getAddress();
        this.date = order.getDate();
    }

    public int getBuyer() {
        return buyer;
    }

    public void setBuyer(int buyer) {
        this.buyer = buyer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
