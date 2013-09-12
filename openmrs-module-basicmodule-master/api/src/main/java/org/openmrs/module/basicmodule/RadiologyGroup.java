/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.basicmodule;

/**
 *
 * @author Neeti
 */
import java.io.Serializable;
import java.util.Date;
import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.Concept;

public class RadiologyGroup extends BaseOpenmrsMetadata implements Serializable {
	
	private Integer id;
	private String uuid;
	private String name;
        private String orderType;
        private String modality;
        private String bodyScan;
        private Date startDate;
        private Date expiryDate;
        private String refPhyName;
        private String perPhyName;
        private String readPhyName;
        private String scheduledStatus;
        private String performedStatus;
        private String addInfo;
	private Concept concept;
        
	public RadiologyGroup() {
	}
	/** constructor with id */
	public RadiologyGroup(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * @param id: id to set
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @return the Id
	 */
	@Override
	public Integer getId() {
		return id;
	}
	
	public String getuuid() {
		return this.uuid;
	}	
	public void setuuid(String uuid) {
		this.uuid = uuid;
	}
	
        @Override
	public String getName() {
		return this.name;
	}
 @Override
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOrderType() {
		return this.orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	public String getModality() {
		return this.modality;
	}
	public void setModality(String modality) {
		this.modality = modality;
	}
        
        public String getBodyScan() {
		return this.bodyScan;
	}
	public void setBodyScan(String bodyScan) {
		this.bodyScan = bodyScan;
	}
	
        public Date getStartDate() {
		return this.startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
        
        public Date getExpiryDate() {
		return this.expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
        
        public String getRefPhyName() {
		return this.refPhyName;
	}
	public void setRefPhyName(String refPhyName) {
		this.refPhyName = refPhyName;
	}
        
        public String getPerPhyName() {
		return this.perPhyName;
	}
	public void setPerPhyName(String perPhyName) {
		this.perPhyName = perPhyName;
	}
        
        public String getReadPhyName() {
		return this.readPhyName;
	}
	public void setReadPhyName(String readPhyName) {
		this.readPhyName = readPhyName;
	}
        
        public String getScheduledStatus() {
		return this.scheduledStatus;
	}
	public void setScheduledStatus(String scheduledStatus) {
		this.scheduledStatus = scheduledStatus;
	}
        
        public String getPerformedStatus() {
		return this.performedStatus;
	}
	public void setPerformedStatus(String performedStatus) {
		this.performedStatus = performedStatus;
	}
        
        public String getAddInfo() {
		return this.addInfo;
	}
	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}
        
	public Concept getConcept() {
		return this.concept;
	}
	
	public void setConcept(Concept concept) {
		this.concept = concept;
	}   

	
	/**
	 * Compares two objects for similarity
	 *
	 */
        @Override
	public boolean equals(Object obj) {
		if (obj instanceof RadiologyGroup) {
			RadiologyGroup pList = (RadiologyGroup) obj;
			if (this.getId() != null && pList.getId() != null) {
				return (this.getId().equals(pList.getId()));
			}
		}
		return this == obj;
	}
	@Override
	public int hashCode() {
		if (this.getId() == null) {
			return super.hashCode();
		}
		return this.getId().hashCode();
	}
	
}