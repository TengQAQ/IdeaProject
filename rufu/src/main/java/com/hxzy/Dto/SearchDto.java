package com.hxzy.Dto;

public class SearchDto extends PageDto{
	private Integer occupation;
	private Integer marriageOtherId;

	public Integer getOccupation() {
		return occupation;
	}

	public void setOccupation(Integer occupation) {
		this.occupation = occupation;
	}

	public Integer getMarriageOtherId() {
		return marriageOtherId;
	}

	public void setMarriageOtherId(Integer marriageOtherId) {
		this.marriageOtherId = marriageOtherId;
	}

	@Override
	public String toString() {
		return "SearchDto{" +
				"occupation='" + occupation + '\'' +
				", marriageOtherId=" + marriageOtherId +
				'}';
	}
}
