package IceFactory.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Staff extends Account {

    private String firstName;
    private String lastName;
    private LocalDateTime dateTime;
    private String phoneNumber;
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    private Owner owner;


    //add order
    //editOrder


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void checkIn(){
        dateTime = LocalDateTime.now();
    }

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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
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
