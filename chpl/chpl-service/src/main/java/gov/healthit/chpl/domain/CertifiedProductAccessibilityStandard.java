package gov.healthit.chpl.domain;

import gov.healthit.chpl.dto.CertifiedProductAccessibilityStandardDTO;

public class CertifiedProductAccessibilityStandard {
	private Long id;
	private Long accessibilityStandardId;
	private String accessibilityStandardName;

	public CertifiedProductAccessibilityStandard() {
		super();
	}
	
	public CertifiedProductAccessibilityStandard(CertifiedProductAccessibilityStandardDTO dto) {
		this.id = dto.getId();
		this.accessibilityStandardId = dto.getAccessibilityStandardId();
		this.accessibilityStandardName = dto.getAccessibilityStandardName();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccessibilityStandardId() {
		return accessibilityStandardId;
	}

	public void setAccessibilityStandardId(Long accessibilityStandardId) {
		this.accessibilityStandardId = accessibilityStandardId;
	}

	public String getAccessibilityStandardName() {
		return accessibilityStandardName;
	}

	public void setAccessibilityStandardName(String accessibilityStandardName) {
		this.accessibilityStandardName = accessibilityStandardName;
	}

}
