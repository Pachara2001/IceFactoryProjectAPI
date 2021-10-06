package IceFactory.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Customer {
    enum CustomerType{
        Delivery,Pickup
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(columnDefinition = "CHAR(36)")
    private UUID customerId;
    private String fName;
    private String lName;
    private String address;
    private String phoneNumber;
    private String type;

    @OneToMany(mappedBy = "customer")
    private Set<CustomerOrder> customerOrders = new HashSet<>();

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<CustomerOrder> getOrders() {
        return customerOrders;
    }

    public void setOrders(Set<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }


}
