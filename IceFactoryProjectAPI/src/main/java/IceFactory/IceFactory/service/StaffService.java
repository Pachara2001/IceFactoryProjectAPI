package IceFactory.IceFactory.service;


import IceFactory.IceFactory.model.Staff;
import IceFactory.IceFactory.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository repository;

    public List<Staff> getAll(){
        return repository.findAll();
    }

    public Staff create(Staff staff){
        repository.save(staff);
        return staff;
    }

    public Staff getStaff(String username){
        return repository.findById(username).get();
    }

    public Staff update(String username,Staff requestBody){
        Staff record = repository.findById(username).get();
        if(requestBody.getPassword()!=null){
            record.setPassword(requestBody.getPassword());}
        if(requestBody.getFirstName()!=null){
            record.setFirstName(requestBody.getFirstName()); }
        if(requestBody.getLastName()!=null){
            record.setLastName(requestBody.getLastName()); }
        if(requestBody.getDateTime()!=null){
            record.setDateTime(requestBody.getDateTime());}
        if(requestBody.getAddress()!=null){
            record.setAddress(requestBody.getAddress()); }
        if(requestBody.getPhoneNumber()!=null){
            record.setPhoneNumber(requestBody.getPhoneNumber()); }
        else throw new IllegalArgumentException("Argument is null!!");
        repository.saveAndFlush(record);
        return record;
    }

    public Staff delete(String username) {
        Staff record = repository.findById(username).get();
        repository.deleteById(username);
        return record;
    }

}
