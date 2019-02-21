package org.openmrs.module.procedureorder.models;

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
	private Integer todoId;
	
	@Basic
	@Column(name = "description")
	private String description;
	
	@Basic
	@Column(name = "due_date")
	private Date dueDate;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient_id;
	
	@Override
	public Integer getId() {
		return getTodoId();
	}
	
	@Override
	public void setId(Integer id) {
		setTodoId(id);
	}
	
	public PatientTodo() {
	}
	
	public PatientTodo(Integer todoId, String description, Date todoDate, Patient patient_id) {
		this.todoId = todoId;
		this.description = description;
		this.dueDate = todoDate;
		this.patient_id = patient_id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date due_date) {
		this.dueDate = due_date;
	}
	
	public Patient getPatient_id() {
		return patient_id;
	}
	
	public void setPatient_id(Patient patient_id) {
		this.patient_id = patient_id;
	}
	
	public Integer getTodoId() {
		return todoId;
	}
	
	public void setTodoId(Integer todo_id) {
		this.todoId = todo_id;
	}
	
	@Override
	public String getUuid() {
		return super.getUuid();
	}
	
	@Override
	public void setUuid(String uuid) {
		super.setUuid(uuid);
	}
	
	@Override
	public void setCreator(User creator) {
		super.setCreator(creator);
	}
	
	@Override
	public User getCreator() {
		return super.getCreator();
	}
	
	@Override
	public Date getDateCreated() {
		return super.getDateCreated();
	}
	
	@Override
	public void setDateCreated(Date dateCreated) {
		super.setDateCreated(dateCreated);
	}
	
	@Override
	public User getChangedBy() {
		return super.getChangedBy();
	}
	
	@Override
	public void setChangedBy(User changedBy) {
		super.setChangedBy(changedBy);
	}
	
	@Override
	public Date getDateChanged() {
		return super.getDateChanged();
	}
	
	@Override
	public void setDateChanged(Date dateChanged) {
		super.setDateChanged(dateChanged);
	}
	
	@Override
	public Boolean isVoided() {
		return super.isVoided();
	}
	
	@Override
	public Boolean getVoided() {
		return super.getVoided();
	}
	
	@Override
	public void setVoided(Boolean voided) {
		super.setVoided(voided);
	}
	
	@Override
	public Date getDateVoided() {
		return super.getDateVoided();
	}
	
	@Override
	public void setDateVoided(Date dateVoided) {
		super.setDateVoided(dateVoided);
	}
	
	@Override
	public User getVoidedBy() {
		return super.getVoidedBy();
	}
	
	@Override
	public void setVoidedBy(User voidedBy) {
		super.setVoidedBy(voidedBy);
	}
	
	@Override
	public String getVoidReason() {
		return super.getVoidReason();
	}
	
	@Override
	public void setVoidReason(String voidReason) {
		super.setVoidReason(voidReason);
	}
}
