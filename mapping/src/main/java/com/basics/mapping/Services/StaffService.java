package com.basics.mapping.Services;

import com.basics.mapping.Models.Staff;
import com.basics.mapping.Repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {

    @Autowired
    StaffRepository staffRepository;

    public Staff saveStaff(Staff staff){
        return staffRepository.save(staff);
    }
}
