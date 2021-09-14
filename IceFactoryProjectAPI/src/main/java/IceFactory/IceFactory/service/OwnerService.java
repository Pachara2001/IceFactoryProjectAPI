package IceFactory.IceFactory.service;

import IceFactory.IceFactory.model.Owner;
import IceFactory.IceFactory.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository repository;

    public List<Owner> getAll(){
        return repository.findAll();
    }

    public Owner create(Owner owner){
        repository.save(owner);
        return owner;
    }

    public Owner getOwner(String username){
        return repository.findById(username).get();
    }

    public Owner update(String username,Owner requestBody){
        Owner record = repository.findById(username).get();
        if(requestBody.getPassword()!=null)
            record.setPassword(requestBody.getPassword());
        else throw new IllegalArgumentException("Password is null!!");
        repository.saveAndFlush(record);
        return record;
    }
}
