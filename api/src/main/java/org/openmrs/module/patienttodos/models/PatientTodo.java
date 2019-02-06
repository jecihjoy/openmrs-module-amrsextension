package org.openmrs.module.patienttodos.models;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.Patient;
import org.openmrs.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patienttodos")
public class PatientTodo extends BaseOpenmrsData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String description;
	
	private Date todo_date;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	public PatientTodo() {
	}
	
	public PatientTodo(String description, Date todo_date, Patient patient) {
		this.description = description;
		this.todo_date = todo_date;
		this.patient = patient;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getTodo_date() {
		return todo_date;
	}
	
	public void setTodo_date(Date todo_date) {
		this.todo_date = todo_date;
	}
}
