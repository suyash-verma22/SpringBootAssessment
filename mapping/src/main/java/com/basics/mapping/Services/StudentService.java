package com.basics.mapping.Services;

import com.basics.mapping.Models.Student;
import com.basics.mapping.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return this.studentRepository.save(student);
    }

    public Optional<Student> getStudent(Integer id){
        return this.studentRepository.findById(id);
    }

    public List<Student> getAllStudent(){
        return this.studentRepository.findAll();
    }

    public void deleteStudent(Integer id){
        this.studentRepository.deleteById(id);
    }

    public Student updateStudent(Student student){
        return this.studentRepository.save(student);
    }
}
