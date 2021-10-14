package IceFactory.service;

import IceFactory.model.Product;
import IceFactory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAll(){ return repository.findAll();}

    public Product create(Product product){
        repository.save(product);
        return product;
    }

    public Product getProduct(String name){ return repository.findById(name).get(); }

    public Product update(String name ,Product requestBody){
        Product record = repository.findById(name).get();
        if(requestBody.getQuantity()>=0){
            record.setQuantity(requestBody.getQuantity());
        }
        if(requestBody.getPrice()>=0){
            record.setPrice(requestBody.getPrice());
        }
        if(requestBody.getPriceDelivery()>=0){
            record.setPriceDelivery(requestBody.getPriceDelivery());
        }
        repository.saveAndFlush(record);
        return record;
    }

    public void delete(String name){
        Product record = repository.findById(name).get();
        repository.deleteById(name);
    }
}
