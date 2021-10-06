package IceFactory.controller;

import IceFactory.model.CustomerOrder;
import IceFactory.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customerorder")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService service;

    @GetMapping
    public List<CustomerOrder> getAll(){ return service.getAll();}

    @PostMapping
    public CustomerOrder create(@RequestBody CustomerOrder customerOrder){return service.create(customerOrder);}

    @GetMapping("/{orderId}")
    public CustomerOrder getCustomerOrder(@PathVariable UUID orderId){ return service.getCustomerOrder(orderId); }

    @PutMapping("/{orderId}")
    public CustomerOrder update(@PathVariable UUID orderId, @RequestBody CustomerOrder customerOrder){
        return service.update(orderId, customerOrder);
    }

    @DeleteMapping("/{orderId}")
    public CustomerOrder delete(@PathVariable UUID orderId){
        return service.delete(orderId);
    }
}
