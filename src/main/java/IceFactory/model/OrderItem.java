package IceFactory.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(columnDefinition = "CHAR(36)")
    private UUID orderItemId;

    @ManyToOne
    @JoinColumn(name="pName", nullable=false)
    private Product product;
    private int orderQuantity;
    private float price;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private CustomerOrder customerOrder;


    public Product getProduct() {
        return product;
    }


    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public UUID getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(UUID orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public void setOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }


}
