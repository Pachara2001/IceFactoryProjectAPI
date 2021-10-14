package IceFactory.service;

import IceFactory.model.Customer;
import IceFactory.model.Staff;
import IceFactory.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public List<Customer> getAll(){
        return repository.findAll();
    }

    public Customer create(Customer customer){
        repository.save(customer);
        return customer;
    }

    public Customer getCustomer(UUID customerId){
        return repository.findById(customerId).get();
    }

    public Customer update(UUID customerId,Customer requestBody){
        Customer record = repository.findById(customerId).get();
        if(requestBody.getAddress()!=null)
            record.setAddress(requestBody.getAddress());
        if(requestBody.getName()!=null)
            record.setName(requestBody.getName());
        if(requestBody.getPhoneNumber()!=null)
            record.setPhoneNumber(requestBody.getPhoneNumber());

        repository.saveAndFlush(record);
        return record;
    }

    public void delete(UUID customerId) {
        Customer record = repository.findById(customerId).get();
        repository.deleteById(customerId);
    }
}
