package org.openmrs.module.amrsordermodule.models;

/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.openmrs.BaseOpenmrsData;
import org.openmrs.OpenmrsMetadata;
import org.openmrs.User;
import org.openmrs.api.APIException;

import javax.persistence.*;

/*@Entity(name = "OrderSetExt")
@Table(name = "order_set_ext")*/
public class OrderSetExt extends BaseOpenmrsData implements OpenmrsMetadata {
	
	public static final long serialVersionUID = 72232L;
	
	/**
	 * Restrictions put on saving an orderSet. ALL: All the members of the orderSet need to be
	 * selected for saving ONE: Only one of the member of the orderSet needs to be selected for
	 * saving ANY: Any of the members of the orderSet can be selected for saving
	 */
	public enum Operator {
		ALL, ONE, ANY
	}
	
	/*	@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "order_set_id")*/
	private Integer orderSetId;
	
	//	@Column(name = "operator")
	private org.openmrs.module.amrsordermodule.models.OrderSetExt.Operator operator;
	
	/*	@OneToMany(mappedBy = "orderSet")
		@JsonBackReference*/
	private List<OrderSetMemberExt> orderSetMembers;
	
	//	@Column(name = "name")
	private String name;
	
	//	@Column(name = "description")
	private String description;
	
	public OrderSetExt() {
	}
	
	@Override
	public Integer getId() {
		return getOrderSetId();
	}
	
	@Override
	public void setId(Integer integer) {
		setOrderSetId(integer);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
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
	
	public void removeOrderSetMember(OrderSetMemberExt orderSetMember) {
		if (getOrderSetMembers().contains(orderSetMember)) {
			getOrderSetMembers().remove(orderSetMember);
			orderSetMember.setOrderSet(null);
		}
	}
	
	@Override
	public User getCreator() {
		return super.getCreator();
	}
	
	@Override
	public void setCreator(User creator) {
		super.setCreator(creator);
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
	
	public void retireOrderSetMember(OrderSetMemberExt orderSetMember) {
		orderSetMember.setRetired(true);
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
