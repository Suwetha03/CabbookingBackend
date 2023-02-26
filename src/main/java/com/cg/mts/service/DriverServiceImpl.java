package com.cg.mts.service;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Cab;
import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;
import com.cg.mts.repository.IDriverRepository;

@Repository
public class DriverServiceImpl implements IDriverService {
	@Autowired
	private IDriverRepository driverRepository;
	@Override
	public List<Driver> displayAllDriver() {
	  return driverRepository.findAll();
	}
	@Override
	public List<Driver> insertDriver(Driver driver) {
	  driverRepository.save(driver);
	  return driverRepository.findAll();
	}
	
	@Override
	@Transactional
	public Driver updateDriver(Driver driver, int driverId) throws DriverNotFoundException {
		Driver updatedDriver = driverRepository.getReferenceById(driverId);
		driverRepository.save(updatedDriver);
		return updatedDriver;
		
	}
	@Override
	public List<Driver> deleteDriver(int driverId) throws DriverNotFoundException {
		driverRepository.deleteById(driverId);
		 return driverRepository.findAll();
		}
	
	@Override
	 public List<Driver> viewBestDrivers() throws DriverNotFoundException{
	  List<Driver> bestDrivers = driverRepository.findAll();
	  return bestDrivers.stream().filter((d) -> d.getRating() >= 4.5).collect(Collectors.toList());
	 }
	
	 @Override
	 public Driver viewDriver(int driverId) throws DriverNotFoundException {
	  return driverRepository.findById(driverId).get();
	 }
	@Override
	public List<Driver> getDriverByExperience(int experience) {
		 driverRepository.findById(experience);
		 return driverRepository.findAll();
	}
	
//	@Override
//	public List<Driver> getDriverByCity(String city) {
//		return driverRepository.getDriverByDriverCity(city);
//	}

	
	
}

















