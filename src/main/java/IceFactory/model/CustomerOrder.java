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
    @Column(columnDefinition = "CHAR(36)")
    private UUID orderId;

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Staff staff;

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

    public void setStaff(Staff staff) {
        this.staff = staff;
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

    public Customer getCustomer() {return this.customer;}


}
