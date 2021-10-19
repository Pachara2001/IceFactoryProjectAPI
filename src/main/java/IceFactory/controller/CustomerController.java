package IceFactory.controller;

import IceFactory.model.Customer;
import IceFactory.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping
    public List<Customer> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer){
        return service.create(customer);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable UUID customerId) {
        return service.getCustomer(customerId);
    }

    @PutMapping("/{customerId}")
    public Customer update(@PathVariable UUID customerId,@RequestBody Customer customer){
        return service.update(customerId,customer);
    }

    @DeleteMapping("/{customerId}")
    public void delete(@PathVariable UUID customerId){
         service.delete(customerId);
    }
}
