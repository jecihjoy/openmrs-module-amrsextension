package org.openmrs.module.amrsordermodule.models;

import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.Concept;

public class PrescriptionTemplate extends BaseOpenmrsMetadata {
	
	private int templateId;
	
	private Concept concept;
	
	private String orderTemplate;
	
	private int type;
	
	private String orderTemplateType;
	
	private String version;
	
	private Boolean published = true;
	
	public PrescriptionTemplate() {
	}
	
	public PrescriptionTemplate(int template_id, Concept concept, String name, String orderTemplate, int type,
	    String orderTemplateType, String description, String version, Boolean published) {
		this.templateId = template_id;
		this.concept = concept;
		setName(name);
		setDescription(description);
		this.orderTemplate = orderTemplate;
		this.type = type;
		this.orderTemplateType = orderTemplateType;
		this.version = version;
		this.published = published;
	}
	
	@Override
	public Integer getId() {
		return getTemplateId();
	}
	
	@Override
	public void setId(Integer id) {
		setTemplateId(id);
	}
	
	public int getTemplateId() {
		return templateId;
	}
	
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	
	public Concept getConcept() {
		return concept;
	}
	
	public void setConcept(Concept concept) {
		this.concept = concept;
	}
	
	public String getOrderTemplate() {
		return orderTemplate;
	}
	
	public void setOrderTemplate(String orderTemplate) {
		this.orderTemplate = orderTemplate;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public String getOrderTemplateType() {
		return orderTemplateType;
	}
	
	public void setOrderTemplateType(String orderTemplateType) {
		this.orderTemplateType = orderTemplateType;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public Boolean getPublished() {
		return published;
	}
	
	public void setPublished(Boolean published) {
		this.published = published;
	}
	
}
