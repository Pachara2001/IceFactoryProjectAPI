package IceFactory.model;




import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Owner extends Account{



    @OneToMany(mappedBy = "owner")
    private  Set<Staff> staffs = new HashSet<>();

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }



}
