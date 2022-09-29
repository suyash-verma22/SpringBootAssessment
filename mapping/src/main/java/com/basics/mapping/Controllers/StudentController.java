package com.basics.mapping.Controllers;

import com.basics.mapping.ExceptionHandlers.ResourceNotFoundException;
import com.basics.mapping.Models.Student;
import com.basics.mapping.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/welcome")
    public String greeting(){
        System.out.println("Hello from Student");
        return "Hello from Student";
    }

    @GetMapping("/find/{id}")
    public Optional<Student> getStudentById(@PathVariable(value = "id") Integer id){
        System.out.println("Hello from Student");
        return this.studentService.getStudent(id);
    }

    @GetMapping("/findAll")
    public List<Student> getStudents(){
        return this.studentService.getAllStudent();
    }

    @PostMapping("/add")
    public void add(@RequestBody Student student){
         this.studentService.saveStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value="id") Integer id){
        this.studentService.deleteStudent(id);
    }

    @PutMapping("/update/{id}")
    public Student update(@RequestBody Student student, @PathVariable(value = "id") Integer id){
        Student oldRecords = this.studentService.getStudent(id).orElseThrow(()
                ->new ResourceNotFoundException("Student with id: " + id +" id not found"));
        oldRecords.setName(student.getName());
        oldRecords.setDepartment(student.getDepartment());
        return this.studentService.updateStudent(oldRecords);
    }

}
