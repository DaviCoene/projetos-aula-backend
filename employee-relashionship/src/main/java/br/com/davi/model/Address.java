package br.com.davi.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "address")
public class Address implements Serializable{

	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "street_name", nullable = false, length = 150)
	private String streetName;
	
	@Column(name = "street_number", nullable = false)
	private Integer streetNumber;
	
	@Column(name = "zip_code", nullable = false, length = 80)
	private String zipCode;
	

	
	private Address(){
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getStreetName() {
		return streetName;
	}



	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}



	public Integer getStreetNumber() {
		return streetNumber;
	}



	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}



	public String getZipCode() {
		return zipCode;
	}



	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id, streetName, streetNumber, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(id, other.id) && Objects.equals(streetName, other.streetName)
				&& Objects.equals(streetNumber, other.streetNumber) && Objects.equals(zipCode, other.zipCode);
	}
	
}
