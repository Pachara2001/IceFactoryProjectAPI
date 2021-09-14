package IceFactory.IceFactory.model;


import IceFactory.IceFactory.service.OwnerService;
import IceFactory.IceFactory.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Owner extends Account{


    @OneToMany(mappedBy = "owner")
    private Set<Staff> staffs = new HashSet<>();

    //editStock
    //edit
    // delete

    public void changePassword(String oldPass, String newPass){
        if(getPassword().equals(oldPass)){
            OwnerService service = new OwnerService();
            this.setPassword(newPass);
            service.update(this.getUsername(),this);
        }
        else throw new IllegalArgumentException("Old password didn't match!!");
    }

    public void createStaff(String username,String password,String fName,String lName,String phone,String address){
        Staff staff = new Staff();
        staff.setUsername(username);
        staff.setPassword(password);
        staff.setFirstName(fName);
        staff.setLastName(lName);
        staff.setPhoneNumber(phone);
        staff.setAddress(address);
        staff.setOwner(this);
        new StaffService().create(staff);
    }

    public Staff deleteStaff(String staffUsername){
        return new StaffService().delete(staffUsername);
    }
}
