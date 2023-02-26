package com.cg.mts.entities;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int driverId;
	private String driverName;
	private String licenceNo;
	private float rating;
	private String category;
	private String city;
	private String nativeLanguage;
	private int experience;
	
	public Driver(int driverId, String driverName, String licenceNo, float rating, String category, String city,
			String nativeLanguage, int experience) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.licenceNo = licenceNo;
		this.rating = rating;
		this.category = category;
		this.city = city;
		this.nativeLanguage = nativeLanguage;
		this.experience = experience;
	}



}





