package org.openmrs.module.procedureorder.models;

import org.openmrs.Concept;
import org.openmrs.Order;
import org.openmrs.OrderFrequency;

import javax.persistence.*;

@Entity(name = "ProcedureOrder")
@Table(name = "procedure_order")
public class ProcedureOrder extends Order {
	
	public static final long serialVersionUID = 1780L;
	
	public enum Laterality {
		LEFT, RIGHT, BILATERAL
	}
	
	@OneToOne(optional = false, targetEntity = Order.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "order_id")
	private Order order;
	
	@Column(name = "clinical_history")
	private String clinicalHistory;
	
	@OneToOne
	@JoinColumn(name = "procedure_name")
	private Concept procedureName;
	
	@ManyToOne
	@JoinColumn(name = "frequency")
	private OrderFrequency frequency;
	
	@Column(name = "requires_specimen")
	private boolean requiresSpecimen;
	
	@ManyToOne
	@JoinColumn(name = "specimen_source")
	private Concept specimenSource;
	
	@Column(name = "number_of_repeats")
	private int numberOfRepeats;
	
	@Column(name = "laterality")
	private Laterality laterality;
	
	@Column(name = "test_notes")
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
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
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
