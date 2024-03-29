package IceFactory.service;

import IceFactory.model.OrderItem;
import IceFactory.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    public List<OrderItem> getAll(){return repository.findAll();}

    public OrderItem create(OrderItem orderItem){
        repository.save(orderItem);
        return orderItem;
    }

    public OrderItem getOrderItem(UUID id){ return repository.findById(id).get(); }

    public void delete(UUID id){
        OrderItem record = repository.findById(id).get();
        repository.deleteById(id);
    }

    public OrderItem update(UUID id,OrderItem requestBody){
        OrderItem record = repository.findById(id).get();
        if(requestBody.getProduct()!=null) record.setProduct(requestBody.getProduct());
        if(requestBody.getPrice()!=0) record.setPrice(requestBody.getPrice());
        repository.saveAndFlush(record);
        return record;
    }
}
