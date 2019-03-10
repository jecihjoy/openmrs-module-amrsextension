/*
package org.openmrs.module.amrsordermodule.models;

import org.openmrs.*;

import javax.persistence.*;

@Entity(name = "DrugSetMember")
@Table(name = "drug_set_member")
public class DrugSetMember extends OrderSetMemberExt {
	
	//	@OneToOne(optional = false, targetEntity = OrderSetMemberExt.class)
	//	@Id
	//	@GeneratedValue(strategy = GenerationType.AUTO)
	*/
/*	@Column(name = "set_member_id")
		private OrderSetMemberExt setMemberExt;*//*


@Column(name = "dose")
private Double dose;

@ManyToOne
@JoinColumn(name = "dose_units")
private Concept doseUnits;

@ManyToOne
@JoinColumn(name = "frequency")
private OrderFrequency frequency;

@Column(name = "as_needed")
private Boolean asNeeded = false;

@Column(name = "quantity")
private Double quantity;

@ManyToOne
@JoinColumn(name = "quantity_units")
private Concept quantityUnits;

@ManyToOne
@JoinColumn(name = "drug_id")
private Drug drug;

@Column(name = "as_needed_condition")
private String asNeededCondition;

@Column(name = "dosing_type")
private Class<? extends DosingInstructions> dosingType = SimpleDosingInstructions.class;

@Column(name = "num_refills")
private Integer numRefills;

@Column(name = "dosing_instructions")
private String dosingInstructions;

@Column(name = "duration")
private Integer duration;

@ManyToOne
@JoinColumn(name = "duration_units")
private Concept durationUnits;

@ManyToOne
@JoinColumn(name = "route")
private Concept route;

@Column(name = "brand_name")
private String brandName;

@Column(name = "dispense_as_written")
private Boolean dispenseAsWritten = Boolean.FALSE;

@Column(name = "drug_non_coded")
private String drugNonCoded;

public DrugSetMember() {
}

public Double getDose() {
return dose;
}

public void setDose(Double dose) {
this.dose = dose;
}

public Concept getDoseUnits() {
return doseUnits;
}

public void setDoseUnits(Concept doseUnits) {
this.doseUnits = doseUnits;
}

public Boolean getAsNeeded() {
return asNeeded;
}

public void setAsNeeded(Boolean asNeeded) {
this.asNeeded = asNeeded;
}

public Double getQuantity() {
return quantity;
}

public void setQuantity(Double quantity) {
this.quantity = quantity;
}

public Concept getQuantityUnits() {
return quantityUnits;
}

public void setQuantityUnits(Concept quantityUnits) {
this.quantityUnits = quantityUnits;
}

public Drug getDrug() {
return drug;
}

public void setDrug(Drug drug) {
this.drug = drug;
}

public String getAsNeededCondition() {
return asNeededCondition;
}

*/
/*
		public OrderSetMemberExt getSetMemberExt() {
			return setMemberExt;
		}

		public void setSetMemberExt(OrderSetMemberExt setMemberExt) {
			this.setMemberExt = setMemberExt;
		}*//*


public void setAsNeededCondition(String asNeededCondition) {
this.asNeededCondition = asNeededCondition;
}

public Class<? extends DosingInstructions> getDosingType() {
return dosingType;
}

public void setDosingType(Class<? extends DosingInstructions> dosingType) {
this.dosingType = dosingType;
}

public Integer getNumRefills() {
return numRefills;
}

public void setNumRefills(Integer numRefills) {
this.numRefills = numRefills;
}

public String getDosingInstructions() {
return dosingInstructions;
}

public void setDosingInstructions(String dosingInstructions) {
this.dosingInstructions = dosingInstructions;
}

public Integer getDuration() {
return duration;
}

public void setDuration(Integer duration) {
this.duration = duration;
}

public Concept getDurationUnits() {
return durationUnits;
}

public void setDurationUnits(Concept durationUnits) {
this.durationUnits = durationUnits;
}

public Concept getRoute() {
return route;
}

public void setRoute(Concept route) {
this.route = route;
}

public String getBrandName() {
return brandName;
}

public void setBrandName(String brandName) {
this.brandName = brandName;
}

public Boolean getDispenseAsWritten() {
return dispenseAsWritten;
}

public void setDispenseAsWritten(Boolean dispenseAsWritten) {
this.dispenseAsWritten = dispenseAsWritten;
}

public String getDrugNonCoded() {
return drugNonCoded;
}

public void setDrugNonCoded(String drugNonCoded) {
this.drugNonCoded = drugNonCoded;
}

public OrderFrequency getFrequency() {
return frequency;
}

public void setFrequency(OrderFrequency frequency) {
this.frequency = frequency;
}

}
*/
