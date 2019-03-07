package org.openmrs.module.amrsordermodule.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.openmrs.BaseOpenmrsData;
import org.openmrs.OpenmrsMetadata;
import org.openmrs.User;
import org.openmrs.api.APIException;

import javax.persistence.Entity;

public class OrderSetExt extends BaseOpenmrsData implements OpenmrsMetadata {
	
	public static final long serialVersionUID = 722322L;
	
	public enum Operator {
		ALL, ONE, ANY
	}
	
	private Integer orderSetId;
	
	private Operator operator;
	
	private List<OrderSetMemberExt> orderSetMembers;
	
	public Integer getOrderSetId() {
		return orderSetId;
	}
	
	public void setOrderSetId(Integer orderSetId) {
		this.orderSetId = orderSetId;
	}
	
	public Operator getOperator() {
		return operator;
	}
	
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	public List<OrderSetMemberExt> getOrderSetMembers() {
		if (orderSetMembers == null) {
			orderSetMembers = new ArrayList<>();
		}
		return orderSetMembers;
	}
	
	public void setOrderSetMembers(List<OrderSetMemberExt> orderSetMembers) {
		this.orderSetMembers = orderSetMembers;
	}
	
	public void addOrderSetMember(OrderSetMemberExt orderSetMember, Integer position) {
		Integer listIndex = findListIndexForGivenPosition(position);
		orderSetMember.setOrderSet(this);
		getOrderSetMembers().add(listIndex, orderSetMember);
	}
	
	private Integer findListIndexForGivenPosition(Integer position) {
		Integer size = getOrderSetMembers().size();
		if (position != null) {
			if (position < 0 && position >= (-1 - size)) {
				position = position + size + 1;
			} else if (position > size) {
				throw new APIException("Cannot add a member which is out of range of the list");
			}
		} else {
			position = size;
		}
		return position;
	}
	
	public void addOrderSetMember(OrderSetMemberExt orderSetMember) {
		this.addOrderSetMember(orderSetMember, null);
	}
	
	@Override
	public Integer getId() {
		return getOrderSetId();
	}
	
	@Override
	public void setId(Integer id) {
		setOrderSetId(id);
	}
	
	public List<OrderSetMemberExt> getUnRetiredOrderSetMembers() {
		List<OrderSetMemberExt> osm = new ArrayList<>();
		for (OrderSetMemberExt orderSetMember : getOrderSetMembers()) {
			if (!orderSetMember.getRetired()) {
				osm.add(orderSetMember);
			}
		}
		return osm;
	}
	
	public void removeOrderSetMember(OrderSetMemberExt orderSetMember) {
		if (getOrderSetMembers().contains(orderSetMember)) {
			getOrderSetMembers().remove(orderSetMember);
			orderSetMember.setOrderSet(null);
		}
	}
	
	public void retireOrderSetMember(OrderSetMemberExt orderSetMember) {
		orderSetMember.setRetired(true);
	}
	
	@Override
	public String getName() {
		return null;
	}
	
	@Override
	public void setName(String s) {
		
	}
	
	@Override
	public String getDescription() {
		return null;
	}
	
	@Override
	public void setDescription(String s) {
		
	}
	
	@Override
	public Boolean isRetired() {
		return null;
	}
	
	@Override
	public Boolean getRetired() {
		return null;
	}
	
	@Override
	public void setRetired(Boolean aBoolean) {
		
	}
	
	@Override
	public User getRetiredBy() {
		return null;
	}
	
	@Override
	public void setRetiredBy(User user) {
		
	}
	
	@Override
	public Date getDateRetired() {
		return null;
	}
	
	@Override
	public void setDateRetired(Date date) {
		
	}
	
	@Override
	public String getRetireReason() {
		return null;
	}
	
	@Override
	public void setRetireReason(String s) {
		
	}
}
