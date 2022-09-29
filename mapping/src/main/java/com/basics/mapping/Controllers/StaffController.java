package com.basics.mapping.Controllers;


import com.basics.mapping.Models.Staff;
import com.basics.mapping.Services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/welcome")
    public String greeting(){
        System.out.println("Hello from Staff");
        return "Hello from Staff";
    }

    @PostMapping("/add")
    public Staff add(@RequestBody Staff staff){
        return this.staffService.saveStaff(staff);
    }
}
