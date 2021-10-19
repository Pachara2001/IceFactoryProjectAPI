package IceFactory.service;

import IceFactory.model.Bill;
import IceFactory.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BillService {

    @Autowired
    private BillRepository repository;

    public List<Bill> getAll(){return repository.findAll();}

    public Bill create(Bill bill){
        repository.save(bill);
        return bill;
    }

    public Bill getBill(UUID id){return repository.findById(id).get();}

    public void delete(UUID id){
        Bill record = repository.findById(id).get();
        repository.deleteById(id);
    }

}
