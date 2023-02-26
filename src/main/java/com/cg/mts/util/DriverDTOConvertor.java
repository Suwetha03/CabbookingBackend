package com.cg.mts.util;

import org.springframework.stereotype.Component;

import com.cg.mts.dto.DriverDTO;
import com.cg.mts.entities.Driver;

@Component
public class DriverDTOConvertor {
	
	public DriverDTO convertTo(Driver driver)
	{
		DriverDTO obj = new DriverDTO();
		obj.setDriverId(driver.getDriverId());
		obj.setDriverName(driver.getDriverName());
		obj.setLicenceNo(driver.getLicenceNo());
		obj.setRating(driver.getRating());
		obj.setCategory(driver.getCategory());
		obj.setCity(driver.getCity());
		obj.setExperience(driver.getExperience());
		obj.setNativeLanguage(driver.getNativeLanguage());
		return obj;
	}
}

	




