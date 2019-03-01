package org.openmrs.module.procedureorder.models;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.Concept;
import org.openmrs.OrderType;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "OrderSetMemberExt")
@Table(name = "order_set_member_ext")
public class OrderSetMemberExt extends BaseOpenmrsMetadata {
	
	public static final long serialVersionUID = 72232L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_set_member_id")
	private Integer orderSetMemberId;
	
	@ManyToOne
	@JoinColumn(name = "order_type")
	private OrderType orderType;
	
	@ManyToOne()
	@JoinColumn(name = "order_set_id")
	@JsonManagedReference
	private OrderSetExt orderSet;
	
	@Column(name = "order_template")
	private String orderTemplate;
	
	@Column(name = "order_template_type")
	private String orderTemplateType;
	
	@ManyToOne
	@JoinColumn(name = "concept_id")
	private Concept concept;
	
	/*@Column(name = "sequence_number")
	private int sequenceNumber;*/
	
	public OrderSetMemberExt() {
	}
	
	/**
	 * Gets the orderSetMemberId
	 * 
	 * @return the orderSetMemberId
	 */
	public Integer getOrderSetMemberId() {
		return orderSetMemberId;
	}
	
	/**
	 * Sets the orderSetMemberId
	 * 
	 * @param orderSetMemberId the orderSetMemberId to set
	 */
	public void setOrderSetMemberId(Integer orderSetMemberId) {
		this.orderSetMemberId = orderSetMemberId;
	}
	
	/**
	 * Gets the orderType
	 * 
	 * @return the orderType
	 */
	public OrderType getOrderType() {
		return orderType;
	}
	
	/**
	 * Sets the orderType
	 * 
	 * @param orderType the orderType to set
	 */
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	
	/**
	 * Gets the orderTemplate
	 * 
	 * @return the orderTemplate
	 */
	public String getOrderTemplate() {
		return orderTemplate;
	}
	
	/**
	 * Sets the orderTemplate
	 * 
	 * @param orderTemplate the orderTemplate to set
	 */
	public void setOrderTemplate(String orderTemplate) {
		this.orderTemplate = orderTemplate;
	}
	
	/**
	 * Returns the orderTemplateType
	 * 
	 * @return the orderTemplateType
	 */
	public String getOrderTemplateType() {
		return orderTemplateType;
	}
	
	/**
	 * It takes in a name of a handler, which defines the schema of orderTemplate to be generated
	 * 
	 * @param orderTemplateType the orderTemplateType to be set
	 */
	public void setOrderTemplateType(String orderTemplateType) {
		this.orderTemplateType = orderTemplateType;
	}
	
	public Concept getConcept() {
		return concept;
	}
	
	public void setConcept(Concept concept) {
		this.concept = concept;
	}
	
	public OrderSetExt getOrderSet() {
		return orderSet;
	}
	
	public void setOrderSet(OrderSetExt orderSet) {
		this.orderSet = orderSet;
	}
	
	@Override
	public Integer getId() {
		return getOrderSetMemberId();
	}
	
	@Override
	public void setId(Integer id) {
		setOrderSetMemberId(id);
	}
}
