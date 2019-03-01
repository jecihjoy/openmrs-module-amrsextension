package org.openmrs.module.procedureorder.models;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.api.APIException;
import org.openmrs.api.context.Context;

import javax.persistence.*;

@Entity(name = "SetMemberType")
@Table(name = "order_setmember_type")
public class SetMemberType extends BaseOpenmrsData {
	
	public static final String DRUG_SET_MEMBER_UUID = "uuid";
	
	public static final String PROCEDURE_SET_MEMBER_UUID = "uuid";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "member_type_id")
	private Integer setMemberTypeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "java_class_name")
	private String javaClassName;
	
	@Column(name = "parent")
	private SetMemberType parent;
	
	public SetMemberType() {
	}
	
	public SetMemberType(String name, String description, String javaClassName) {
		setName(name);
		setDescription(description);
		setJavaClassName(javaClassName);
	}
	
	public Integer getSetMemberTypeId() {
		return setMemberTypeId;
	}
	
	public void setSetMemberTypeId(Integer setMemberTypeId) {
		this.setMemberTypeId = setMemberTypeId;
	}
	
	public String getJavaClassName() {
		return javaClassName;
	}
	
	public void setJavaClassName(String javaClassName) {
		this.javaClassName = javaClassName;
	}
	
	public SetMemberType getParent() {
		return parent;
	}
	
	public void setParent(SetMemberType parent) {
		this.parent = parent;
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
	
	@Override
	public Integer getId() {
		return getSetMemberTypeId();
	}
	
	@Override
	public void setId(Integer id) {
		setSetMemberTypeId(id);
	}
	
	public Class getJavaClass() {
		try {
			return Context.loadClass(javaClassName);
		}
		catch (ClassNotFoundException e) {
			//re throw as a runtime exception
			throw new APIException("SetMemberType.failed.load.class", new Object[] { javaClassName }, e);
		}
	}
}
