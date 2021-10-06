package IceFactory.service;

import IceFactory.model.CustomerOrder;
import IceFactory.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerOrderService {

    @Autowired
    private CustomerOrderRepository repository;

    public List<CustomerOrder> getAll(){return repository.findAll();}

    public CustomerOrder create(CustomerOrder customerOrder){
        repository.save(customerOrder);
        return customerOrder;
    }

    public CustomerOrder getCustomerOrder(UUID id){return repository.findById(id).get();}

    public CustomerOrder update(UUID id, CustomerOrder requestBody){
        CustomerOrder record = repository.findById(id).get();
        record.setOrderStatus(requestBody.getOrderStatus());
        repository.saveAndFlush(record);
        return record;
    }

    public CustomerOrder delete(UUID id){
        CustomerOrder record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }
}
