package org.openmrs.module.procedureorder.models;

import org.openmrs.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "ProcedureOrder")
@Table(name = "procedure_order")
public class ProcedureOrder extends Order {
	
	public static final long serialVersionUID = 1780L;
	
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
	
	@OneToMany
	@JoinColumn(name = "procedure_test")
	private List<ProcedureTest> procedureTest;
	
	public ProcedureOrder() {
	}
	
	/*	@Override
		public ProcedureOrder copy() {
			return copyHelper(new ProcedureOrder());
		}
		
		protected ProcedureOrder copyHelper(ProcedureOrder target) {
			super.copyHelper(target);
			target.clinicalHistory = getClinicalHistory();
			target.procedureName = getProcedureName();
			target.frequency = getFrequency();
			target.procedureTest = getProcedureTest();
			
			return target;
		}*/
	
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
	
	public List<ProcedureTest> getProcedureTest() {
		return procedureTest;
	}
	
	public void setProcedureTest(List<ProcedureTest> procedureTest) {
		this.procedureTest = procedureTest;
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
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer integer) {
		
	}
}
