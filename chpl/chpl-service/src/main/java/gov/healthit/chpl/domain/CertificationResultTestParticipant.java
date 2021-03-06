package gov.healthit.chpl.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import gov.healthit.chpl.dto.CertificationResultTestTaskParticipantDTO;

public class CertificationResultTestParticipant {
	private static final Logger logger = LogManager.getLogger(CertificationResultTestParticipant.class);

	private Long id;
	private String uniqueId;
	private Long testParticipantId;
	private String gender;
	private Long educationTypeId;
	private String educationTypeName;
	private Long ageRangeId;
	private String ageRange;
	private String occupation;
	private Integer professionalExperienceMonths;
	private Integer computerExperienceMonths;
	private Integer productExperienceMonths;
	private String assistiveTechnologyNeeds;

	public CertificationResultTestParticipant() {
		super();
	}
	
	public CertificationResultTestParticipant(CertificationResultTestTaskParticipantDTO dto) {
		this.id = dto.getId();
		this.testParticipantId = dto.getTestParticipantId();
		if(dto.getTestParticipant() != null) {
			this.gender = dto.getTestParticipant().getGender();
			this.educationTypeId = dto.getTestParticipant().getEducationTypeId();
			if(dto.getTestParticipant().getEducationType() != null) {
				this.educationTypeName = dto.getTestParticipant().getEducationType().getName();
			}
			this.ageRangeId = dto.getTestParticipant().getAgeRangeId();
			if(dto.getTestParticipant().getAgeRange() != null) {
				this.ageRange = dto.getTestParticipant().getAgeRange().getAge();
			}
			this.occupation = dto.getTestParticipant().getOccupation();
			this.professionalExperienceMonths = dto.getTestParticipant().getProfessionalExperienceMonths();
			this.computerExperienceMonths = dto.getTestParticipant().getComputerExperienceMonths();
			this.productExperienceMonths = dto.getTestParticipant().getProductExperienceMonths();
			this.assistiveTechnologyNeeds = dto.getTestParticipant().getAssistiveTechnologyNeeds();
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTestParticipantId() {
		return testParticipantId;
	}

	public void setTestParticipantId(Long testParticipantId) {
		this.testParticipantId = testParticipantId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getEducationTypeId() {
		return educationTypeId;
	}

	public void setEducationTypeId(Long educationTypeId) {
		this.educationTypeId = educationTypeId;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Integer getProfessionalExperienceMonths() {
		return professionalExperienceMonths;
	}

	public void setProfessionalExperienceMonths(String value) {
		if(!StringUtils.isEmpty(value)) {
	        try {
	        	professionalExperienceMonths = Math.round(new Float(value));
	        } catch (NumberFormatException e) {
	           logger.error("can't parse " + value + " as a float or integer.");
	        }
		}
    }
	
	public Integer getComputerExperienceMonths() {
		return computerExperienceMonths;
	}
	
	public void setComputerExperienceMonths(String value) {
		if(!StringUtils.isEmpty(value)) {
	        try {
	        	computerExperienceMonths = Math.round(new Float(value));
	        } catch (NumberFormatException e) {
	           logger.error("can't parse " + value + " as a float or integer.");
	        }
		}
    }
	
	public Integer getProductExperienceMonths() {
		return productExperienceMonths;
	}

	public void setProductExperienceMonths(String value) {
		if(!StringUtils.isEmpty(value)) {
	        try {
	        	productExperienceMonths = Math.round(new Float(value));
	        } catch (NumberFormatException e) {
	           logger.error("can't parse " + value + " as a float or integer.");
	        }
		}
    }
	
	public String getAssistiveTechnologyNeeds() {
		return assistiveTechnologyNeeds;
	}

	public void setAssistiveTechnologyNeeds(String assistiveTechnologyNeeds) {
		this.assistiveTechnologyNeeds = assistiveTechnologyNeeds;
	}

	public String getEducationTypeName() {
		return educationTypeName;
	}

	public void setEducationTypeName(String educationTypeName) {
		this.educationTypeName = educationTypeName;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Long getAgeRangeId() {
		return ageRangeId;
	}

	public void setAgeRangeId(Long ageRangeId) {
		this.ageRangeId = ageRangeId;
	}

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

}
