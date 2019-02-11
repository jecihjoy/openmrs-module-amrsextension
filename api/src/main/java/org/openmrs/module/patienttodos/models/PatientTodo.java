package org.openmrs.module.patienttodos.models;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.Patient;
import org.openmrs.User;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "PatientTodo")
@Table(name = "patienttodos")
public class PatientTodo extends BaseOpenmrsData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "todo_id")
	private Integer todo_id;
	
	@Basic
	@Column(name = "description")
	private String description;
	
	@Basic
	@Column(name = "due_date")
	private Date due_date;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient_id;
	
	@Override
	public Integer getId() {
		return getTodo_id();
	}
	
	@Override
	public void setId(Integer id) {
		setTodo_id(id);
	}
	
	public PatientTodo() {
	}
	
	public PatientTodo(Integer todo_id, String description, Date todo_date, Patient patient_id) {
		this.todo_id = todo_id;
		this.description = description;
		this.due_date = todo_date;
		this.patient_id = patient_id;
	}
	
	@Override
	public User getCreator() {
		return super.getCreator();
	}
	
	@Override
	public String getUuid() {
		return super.getUuid();
	}
	
	@Override
	public void setUuid(String uuid) {
		super.setUuid(uuid);
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDue_date() {
		return due_date;
	}
	
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	
	public Patient getPatient_id() {
		return patient_id;
	}
	
	public void setPatient_id(Patient patient_id) {
		this.patient_id = patient_id;
	}
	
	public Integer getTodo_id() {
		return todo_id;
	}
	
	public void setTodo_id(Integer todo_id) {
		this.todo_id = todo_id;
	}
	
}
