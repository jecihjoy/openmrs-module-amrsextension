package org.openmrs.module.procedureorder.models;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.Concept;

import javax.persistence.*;

@Entity(name = "ProcedureTest")
@Table(name = "procedure_tests")
public class ProcedureTest extends BaseOpenmrsData {
	
	public enum Laterality {
		LEFT, RIGHT, BILATERAL
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "procedure_test_id")
	private int testId;
	
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
	
	public ProcedureTest() {
	}
	
	public ProcedureTest(int testId, boolean requiresSpecimen, Concept specimenSource, int numberOfRepeats,
	    Laterality laterality, String testNotes) {
		this.testId = testId;
		this.requiresSpecimen = requiresSpecimen;
		this.specimenSource = specimenSource;
		this.numberOfRepeats = numberOfRepeats;
		this.laterality = laterality;
		this.testNotes = testNotes;
	}
	
	@Override
	public Integer getId() {
		return getTestId();
	}
	
	@Override
	public void setId(Integer id) {
		setTestId(id);
	}
	
	public int getTestId() {
		return testId;
	}
	
	public void setTestId(int testId) {
		this.testId = testId;
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
