package org.openmrs.module.openmrscustomizations.models;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.module.appointmentscheduling.Appointment;

public class TestEncounter extends BaseOpenmrsData {
	
	private String name;
	
	private int age;
	
	private Appointment appointment;
	
	public TestEncounter() {
	}
	
	public TestEncounter(String name, int age, Appointment appointment) {
		this.name = name;
		this.age = age;
		this.appointment = appointment;
	}
	
	/*	public TestEncounter(String name, int age) {
			this.name = name;
			this.age = age;
		}*/
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Appointment getEncounter() {
		return appointment;
	}
	
	public void setEncounter(Appointment encounter) {
		this.appointment = encounter;
	}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer integer) {
		
	}
}
