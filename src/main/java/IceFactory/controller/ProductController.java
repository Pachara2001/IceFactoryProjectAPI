package IceFactory.controller;

import IceFactory.model.Product;
import IceFactory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping
    public List<Product> getAll(){return service.getAll();}

    @PostMapping
    public Product create(@RequestBody Product product){return service.create(product);}

    @GetMapping("/{name}")
    public Product getProduct(@PathVariable String name){return service.getProduct(name);}

    @PutMapping("/{name}")
    public Product update(@PathVariable String name,@RequestBody Product product){
        return service.update(name,product);
    }

    @DeleteMapping("/{name}")
    public void delete(@PathVariable String name) { service.delete(name);}
}
