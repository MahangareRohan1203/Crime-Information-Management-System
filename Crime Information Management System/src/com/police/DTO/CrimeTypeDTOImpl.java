package com.police.DTO;

public class CrimeTypeDTOImpl implements CrimeTypeDTO {

	private int no_of_crime;
	private String type;
	public CrimeTypeDTOImpl(int no_of_crime, String type) {
		super();
		this.no_of_crime = no_of_crime;
		this.type = type;
	}
	
	@Override
	public int getNo_of_crime() {
		return no_of_crime;
	}
	
	@Override
	public void setNo_of_crime(int no_of_crime) {
		this.no_of_crime = no_of_crime;
	}
	
	@Override
	public String getType() {
		return type;
	}
	
	@Override
	public void setType(String type) {
		this.type = type;
	}
	
	
}
