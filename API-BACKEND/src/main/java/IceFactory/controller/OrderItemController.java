package IceFactory.controller;

import IceFactory.model.OrderItem;
import IceFactory.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
    @Autowired
    private OrderItemService service;

    @GetMapping
    public List<OrderItem> getAll(){return service.getAll();}

    @PostMapping
    public OrderItem create(@RequestBody OrderItem orderItem){return service.create(orderItem);}

    @GetMapping("/{orderItemId}")
    public OrderItem getOrderItem(@PathVariable UUID orderItemId){
        return service.getOrderItem(orderItemId);
    }

    @DeleteMapping("/{orderItemId}")
    public void delete(@PathVariable UUID orderItemId){  service.delete(orderItemId);}
}
