package gov.healthit.chpl.dto;

import gov.healthit.chpl.entity.TestStandardEntity;

public class TestStandardDTO {
	private Long id;
	private String description;
	private String name;
	
	public TestStandardDTO(){}
	
	public TestStandardDTO(TestStandardEntity entity){		
		this.id = entity.getId();
		this.description = entity.getDescription();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String name) {
		this.description = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String number) {
		this.name = number;
	}
}
