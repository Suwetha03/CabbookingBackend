package com.cg.mts.dto;
import com.cg.mts.entities.Driver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DriverDTO {

	private int driverId;
	private String driverName;
	private String licenceNo;
	private float rating;
	private String category;
	private String city;
	private String nativeLanguage;
	private int experience;


}
