package IceFactory.controller;


import IceFactory.model.Owner;
import IceFactory.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService service;

    @GetMapping
    public List<Owner> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Owner create(@RequestBody Owner owner){
        return service.create(owner);
    }

    @GetMapping("/{username}")
    public Owner getOwner(@PathVariable String username) {
        return service.getOwner(username);
    }


    @PutMapping("/{username}")
    public Owner update(@PathVariable String username,
                             @RequestBody Owner owner) {
        return service.update(username, owner);
    }



}
