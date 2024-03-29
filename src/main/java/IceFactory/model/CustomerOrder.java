package IceFactory.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
public class CustomerOrder {
    public enum Status{
        PrepareProduct,
        WaitForDelivery,
        CloseOrder
    }
    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(columnDefinition = "CHAR(36)", name = "order_id")
    private UUID orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @OneToMany(mappedBy = "customerOrder")
    private List<OrderItem> orderItemList = new ArrayList<>();
    private String orderStatus = Status.PrepareProduct.toString();
    private String orderDate;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String status) {
        this.orderStatus = status;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

//    public void setBill(Bill bill) {
//        this.bill = bill;
//    }

    public Customer getCustomer() {return this.customer;}


}
