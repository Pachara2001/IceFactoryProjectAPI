package IceFactory.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    private String pName;
    private int quantity;
    private float price;
    private float priceDelivery;

    @OneToMany(mappedBy = "product")
    private Set<OrderItem> items = new HashSet<>();


    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPriceDelivery() {
        return priceDelivery;
    }

    public void setPriceDelivery(float priceDelivery) {
        this.priceDelivery = priceDelivery;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }


}
