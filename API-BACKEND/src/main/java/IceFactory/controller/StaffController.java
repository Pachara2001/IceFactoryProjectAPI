package IceFactory.controller;

import IceFactory.model.Staff;
import IceFactory.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService service;

    @GetMapping
    public List<Staff> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Staff create(@RequestBody Staff staff){
        return service.create(staff);
    }

    @GetMapping("/{username}")
    public Staff getStaff(@PathVariable String username) {
        return service.getStaff(username);
    }

    @PutMapping("/{username}")
    public Staff update(@PathVariable String username,
                        @RequestBody Staff staff) {
        return service.update(username, staff);
    }

    @DeleteMapping("/{username}")
    public Staff delete(@PathVariable String username) {
        return service.delete(username);
    }

}
