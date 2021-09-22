package IceFactory.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Staff extends Account {

    private String firstName;
    private String lastName;
    private String dateTime;
    private String phoneNumber;
    private String address;

//    @JsonBackReference
    @ManyToOne
    private Owner owner;


    //add order
    //editOrder


    public void setOwner(Owner owner) {
        this.owner = owner;
    }

//    public void checkIn(){
//        dateTime = LocalDateTime.now();
//    }

//    public Staff logIn(String username,String password){
//        try {
//            if(entryCheck(username,password)){
//                checkIn();
//                return this;}
//        }
//        catch (IllegalArgumentException e){
//            throw new IllegalArgumentException(e.getMessage());
//        }
//        return null;
//        }


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
}
