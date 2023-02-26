package com.cg.mts.repository;
import java.util.List;

import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;

public interface CustomDriverRepository {
		public Driver insertDriver(Driver driver);
		public Driver updateDriver(Driver driver) throws DriverNotFoundException;
		public Driver deleteDriver(Driver driver) throws  DriverNotFoundException;
		public List<Driver> viewBestDriver(int driverId) throws DriverNotFoundException;
		public Driver viewDriver(int driverId) throws DriverNotFoundException ;
		public List<Driver> getDriverByExperience(int experience) throws DriverNotFoundException;
//		public List<Driver> getDriverByCity(String city) throws DriverNotFoundException;

	}

