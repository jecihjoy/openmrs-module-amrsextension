package org.openmrs.module.amrsordermodule.models;

import org.openmrs.Concept;
import org.openmrs.Order;
import org.openmrs.OrderFrequency;

import javax.persistence.*;

public class ProcedureOrder extends Order {
	
	public static final long serialVersionUID = 1780L;
	
	public enum Laterality {
		LEFT, RIGHT, BILATERAL
	}
	
	private String clinicalHistory;
	
	private Concept procedureName;
	
	private OrderFrequency frequency;
	
	private boolean requiresSpecimen;
	
	private Concept specimenSource;
	
	private int numberOfRepeats;
	
	private Laterality laterality;
	
	private String testNotes;
	
	public ProcedureOrder() {
	}
	
	public Concept getProcedureName() {
		return procedureName;
	}
	
	public void setProcedureName(Concept procedureName) {
		this.procedureName = procedureName;
	}
	
	public OrderFrequency getFrequency() {
		return frequency;
	}
	
	public void setFrequency(OrderFrequency frequency) {
		this.frequency = frequency;
	}
	
	public String getClinicalHistory() {
		return clinicalHistory;
	}
	
	public void setClinicalHistory(String clinicalHistory) {
		this.clinicalHistory = clinicalHistory;
	}
	
	public boolean isRequiresSpecimen() {
		return requiresSpecimen;
	}
	
	public void setRequiresSpecimen(boolean requiresSpecimen) {
		this.requiresSpecimen = requiresSpecimen;
	}
	
	public Concept getSpecimenSource() {
		return specimenSource;
	}
	
	public void setSpecimenSource(Concept specimenSource) {
		this.specimenSource = specimenSource;
	}
	
	public int getNumberOfRepeats() {
		return numberOfRepeats;
	}
	
	public void setNumberOfRepeats(int numberOfRepeats) {
		this.numberOfRepeats = numberOfRepeats;
	}
	
	public Laterality getLaterality() {
		return laterality;
	}
	
	public void setLaterality(Laterality laterality) {
		this.laterality = laterality;
	}
	
	public String getTestNotes() {
		return testNotes;
	}
	
	public void setTestNotes(String testNotes) {
		this.testNotes = testNotes;
	}
}
