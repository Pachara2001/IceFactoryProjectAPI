package IceFactory.controller;

import IceFactory.model.Bill;
import IceFactory.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService service;

    @GetMapping
    public List<Bill> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Bill create(@RequestBody Bill bill){
        return service.create(bill);
    }

    @GetMapping("/{billId}")
    public Bill getBill(@PathVariable UUID billId) {
        return service.getBill(billId);
    }

    @DeleteMapping("/{billId}")
    public void delete(@PathVariable UUID billId){
        service.delete(billId);
    }
}
