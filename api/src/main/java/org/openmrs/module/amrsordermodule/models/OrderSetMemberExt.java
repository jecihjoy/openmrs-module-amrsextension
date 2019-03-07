package org.openmrs.module.amrsordermodule.models;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.openmrs.BaseOpenmrsData;
import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.Concept;
import org.openmrs.OrderType;

public class OrderSetMemberExt extends BaseOpenmrsMetadata {
	
	public static final long serialVersionUID = 722322L;
	
	private Integer orderSetMemberId;
	
	private OrderType orderType;
	
	private OrderSetExt orderSet;
	
	private String orderTemplate;
	
	private String orderTemplateType;
	
	private SetMemberType setMemberType;
	
	private Concept concept;
	
	public Integer getOrderSetMemberId() {
		return orderSetMemberId;
	}
	
	public void setOrderSetMemberId(Integer orderSetMemberId) {
		this.orderSetMemberId = orderSetMemberId;
	}
	
	public OrderType getOrderType() {
		return orderType;
	}
	
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	
	public String getOrderTemplate() {
		return orderTemplate;
	}
	
	public void setOrderTemplate(String orderTemplate) {
		this.orderTemplate = orderTemplate;
	}
	
	public String getOrderTemplateType() {
		return orderTemplateType;
	}
	
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
	
	public SetMemberType getSetMemberType() {
		return setMemberType;
	}
	
	public void setSetMemberType(SetMemberType setMemberType) {
		this.setMemberType = setMemberType;
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
