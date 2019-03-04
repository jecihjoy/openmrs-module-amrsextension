package org.openmrs.module.amrsordermodule.models;

import org.openmrs.Concept;

import javax.persistence.*;

@Entity(name = "ProcedureSetMember")
@Table(name = "procedure_set_member")
public class ProcedureSetMember extends OrderSetMemberExt {
	
	public enum Laterality {
		LEFT, RIGHT, BILATERAL
	}
	
	/*	@OneToOne(optional = false, targetEntity = OrderSetMemberExt.class)
		//	@Id
		//	@GeneratedValue(strategy = GenerationType.AUTO)
		@JoinColumn(name = "set_member_id")
		private OrderSetMemberExt setMemberExt;*/
	
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
	
	public ProcedureSetMember() {
	}
	
	public ProcedureSetMember(boolean requiresSpecimen, Concept specimenSource, int numberOfRepeats, Laterality laterality,
	    String testNotes) {
		this.requiresSpecimen = requiresSpecimen;
		this.specimenSource = specimenSource;
		this.numberOfRepeats = numberOfRepeats;
		this.laterality = laterality;
		this.testNotes = testNotes;
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
