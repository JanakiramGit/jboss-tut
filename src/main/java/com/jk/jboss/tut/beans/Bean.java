package com.jk.jboss.tut.beans;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jk.jboss.tut.model.Student;
import com.jk.jboss.tut.service.StudentService;

@Named
@RequestScoped
public class Bean {

	private Student message = new Student();
    private List<Student> messages;

    @Inject
    private StudentService studentService;

    @PostConstruct
    public void init() {
        messages = studentService.list();
    }
    
    public void submit() {
        studentService.create(message);
        messages.add(message);
        message = new Student();
    }
    
    public void deleteStudentById() {
    	studentService.deleteStudentById();
    }
    
    public Student getMessage() {
        return message;
    }
    
    public List<Student> getMessages() {
        return messages;
    }
    
}
