package com.ming.dto;

public class DelateCateDto {
	private Long categoryId;
	private Integer categoryLevel;

	@Override
	public String toString() {
		return "DelateCateDto{" +
				"categoryId=" + categoryId +
				", categoryLevel=" + categoryLevel +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DelateCateDto)) return false;

		DelateCateDto that = (DelateCateDto) o;

		if (getCategoryId() != null ? !getCategoryId().equals(that.getCategoryId()) : that.getCategoryId() != null)
			return false;
		return getCategoryLevel() != null ? getCategoryLevel().equals(that.getCategoryLevel()) : that.getCategoryLevel() == null;
	}

	@Override
	public int hashCode() {
		int result = getCategoryId() != null ? getCategoryId().hashCode() : 0;
		result = 31 * result + (getCategoryLevel() != null ? getCategoryLevel().hashCode() : 0);
		return result;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(Integer categoryLevel) {
		this.categoryLevel = categoryLevel;
	}
}
