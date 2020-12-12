package com.jk.jboss.tut.service;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jk.jboss.tut.model.Student;

@Stateless
public class StudentService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(Student message) {
		entityManager.persist(message);
	}
	
	public List<Student> list(){

		return entityManager
	            .createQuery("FROM Student s", Student.class)
	            .getResultList();
		
	}
	
	public String deleteStudentById() {
    	FacesContext fc = FacesContext.getCurrentInstance();
    	Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
    	
    	String id = params.get("id");
    	System.out.println(id);
    	
    	entityManager.createQuery("DELETE FROM Studnet s where sid = ?1", Student.class).
    	setParameter(1, new Long(id)).executeUpdate();
    	
    	
    	return "/test.xhtml?faces-redirect=true";
    	
    }
}
