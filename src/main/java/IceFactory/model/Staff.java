package IceFactory.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Staff extends Account {

    private String firstName;
    private String lastName;
    private String dateTime;
    private String phoneNumber;
    private String address;
    @ManyToOne
    @JoinColumn(name = "username", nullable=false)
    private Owner owner;
    @OneToMany
    private Set<CustomerOrder> customerOrders = new HashSet<>();

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Owner getOwner() {
        return owner;
    }
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrders(Set<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }


}
