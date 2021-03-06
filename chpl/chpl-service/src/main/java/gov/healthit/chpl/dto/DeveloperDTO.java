package gov.healthit.chpl.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gov.healthit.chpl.domain.Statuses;
import gov.healthit.chpl.entity.DeveloperEntity;

public class DeveloperDTO {

	private String developerCode;
	private Long id;
	private AddressDTO address;
	private ContactDTO contact;
	private Date creationDate;
	private Boolean deleted;
	private Date lastModifiedDate;
	private Long lastModifiedUser;
	private String name;
	private String website;
	private List<DeveloperACBMapDTO> transparencyAttestationMappings;
	private Statuses statuses;
	
	public DeveloperDTO(){
		this.transparencyAttestationMappings = new ArrayList<DeveloperACBMapDTO>();
	}
	
	public DeveloperDTO(DeveloperEntity entity){
		this();
		this.id = entity.getId();
		this.developerCode = entity.getDeveloperCode();
		if(entity.getAddress() != null) {
			this.address = new AddressDTO(entity.getAddress());			
		}
		if(entity.getContact() != null) {
			this.contact = new ContactDTO(entity.getContact());
		}
		this.creationDate = entity.getCreationDate();
		this.deleted = entity.isDeleted();
		this.lastModifiedDate = entity.getLastModifiedDate();
		this.lastModifiedUser = entity.getLastModifiedUser();
		this.name = entity.getName();
		this.website = entity.getWebsite();
		if(entity.getDeveloperCertificationStatusesEntity() != null){
			this.statuses = new Statuses(entity.getDeveloperCertificationStatusesEntity().getActive(), 
					entity.getDeveloperCertificationStatusesEntity().getRetired(), 
					entity.getDeveloperCertificationStatusesEntity().getWithdrawn(), 
					entity.getDeveloperCertificationStatusesEntity().getTerminated(), 
					entity.getDeveloperCertificationStatusesEntity().getSuspended());
		}
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public Long getLastModifiedUser() {
		return lastModifiedUser;
	}
	public void setLastModifiedUser(Long lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDeveloperCode() {
		return developerCode;
	}

	public void setDeveloperCode(String developerCode) {
		this.developerCode = developerCode;
	}
	
	public ContactDTO getContact() {
		return contact;
	}

	public void setContact(ContactDTO contact) {
		this.contact = contact;
	}

	public List<DeveloperACBMapDTO> getTransparencyAttestationMappings() {
		return transparencyAttestationMappings;
	}

	public void setTransparencyAttestationMappings(List<DeveloperACBMapDTO> transparencyAttestationMappings) {
		this.transparencyAttestationMappings = transparencyAttestationMappings;
	}
	
	public Statuses getStatuses(){
		return statuses;
	}
	
	public void setStatuses(Statuses statuses){
		this.statuses = statuses;
	}

}
