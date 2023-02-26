package com.cg.mts.controller;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.mts.dto.DriverDTO;
import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;
import com.cg.mts.service.IDriverService;
import com.cg.mts.util.DriverDTOConvertor;

@RestController
@CrossOrigin(origins = {"http://localhost:51977", "http://localhost:8001"},allowedHeaders = "*")
@RequestMapping("/driver")
public class DriverController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	IDriverService driverService;
	

	public DriverController() {
		logger.info("Driver Controller called");
		System.err.println("------Driver Controller called-------");
	}
	@GetMapping("/display")
	public List<Driver> displayAllDrivers() {
		return driverService.displayAllDriver();
	}

	@PostMapping("/add")
	public List<Driver> insertDriver(@RequestBody Driver driver) {
		return driverService.insertDriver(driver);
	}
	
	@PutMapping("/update/{driverId}")
	public String updatedDriver(@PathVariable int driverId) throws DriverNotFoundException 
	{
		Driver updatedDriver = driverService.viewDriver(driverId);
	return updatedDriver.toString();
	}
	
	@DeleteMapping("/delete/{driverId}")
	public List<Driver> deleteDriver(@PathVariable int driverId) throws DriverNotFoundException {
		List<Driver> d = null;
		try {
			d = driverService.deleteDriver(driverId);
		} catch (Exception e) {
			throw new DriverNotFoundException("Driver with Id: " + driverId + " Not Found To Delete!");
		}
		return d;
	}
	 @GetMapping("/bestdrivers")
	 public List<Driver> viewBestDrivers() throws DriverNotFoundException {
	  List<Driver> lis = null;
	  try {
	   lis = driverService.viewBestDrivers();
	  } catch (Exception e) {
	   throw new DriverNotFoundException("Best Drivers List is Empty");
	  }
	  return lis;
	 }
	 @GetMapping("/{driverId}")
		public Driver viewDriver(@PathVariable int driverId) throws DriverNotFoundException {
			Driver driver = null;
			try {
				driver = driverService.viewDriver(driverId);
			} catch (Exception e) {
				throw new DriverNotFoundException("Driver with Id: " + driverId + " Not Found!");
			}
			return driver;
		}
//	 
//	 @GetMapping("/course/category/{category}")
//		public ResponseEntity<List<DriverDTO>> getDriverByCity(@PathVariable String city)
//		{
//			List<Driver> allDriver = driverService.getDriverByCity(city);
//			List<DriverDTO> allDriverDTO = new ArrayList<>();
//			
//			for (Driver driver : allDriver) {
//				
//				allDriverDTO.add(DriverDTOConvertor.getDriverDTO(driver));
//				
//			}
//			
//			return new ResponseEntity<List<DriverDTO>>(getDriverDTO,HttpStatus.OK);
//		}
////		
//	 @GetMapping("basedOnCity/{city}")
//		public Driver getDriverByCity(@PathVariable String city) throws DriverNotFoundException {
//			Driver driver = null;
//			try {
//				driver = driverService.viewCity(city);
//			} catch (Exception e) {
//				throw new DriverNotFoundException("Driver with experience: " + city + " Not Found!");
//			}
//			return driver;
		}
//	 @GetMapping("basedOnExperience/{experience}")
//		public Driver getDriverByExperience(@PathVariable int experience) throws DriverNotFoundException {
//			Driver driver = null;
//			try {
//				driver = driverService.viewDriver(experience);
//			} catch (Exception e) {
//				throw new DriverNotFoundException("Driver with experience: " + experience + " Not Found!");
//			}
//			return driver;
//		}











//package com.cg.mts.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.cg.mts.entities.Driver;
//import com.cg.mts.exception.DriverNotFoundException;
//import com.cg.mts.repository.ICabRepository;
//import com.cg.mts.repository.IDriverRepository;
//import com.cg.mts.service.IDriverService;
//import com.cg.mts.util.DriverDTOConvertor;
//
//@RestController
//@RequestMapping("/driver")
//@CrossOrigin(origins = {"http://localhost:60957", "http://localhost:8001"},allowedHeaders = "*")
//public class DriverController {
//	
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//	
//	@Autowired
//	IDriverService driverService;
//	
//	@Autowired
//	IDriverRepository driverRepository;
//	
//	@Autowired
//	ICabRepository cabRepository;
//	
//	@Autowired
//	DriverDTOConvertor dtoConvertor;
//	
//
//	public DriverController() {
//		logger.info("Driver Controller called");
//		System.err.println("------Driver Controller called-------");
//	}
//	@GetMapping("/display")
//	public List<Driver> displayAllDrivers() {
//		return driverService.displayAllDriver();
//	}
//
//	@PostMapping("/register")
//	public String insertDriver(@RequestBody Driver driver) {
//	driverService.insertDriver(driver);
//	return "savedDriver";
//	}
//	
//
//	@PutMapping("/updatedriver/{driverId}")
//	public String updateDriverByID(@RequestBody Driver driver, @PathVariable int driverId) throws DriverNotFoundException
//	{
//		Driver updateDriver = driverService.updateDriver(driver, driverId);
//		if(updateDriver() != null)
//		{
//			return updateDriver.toString();
//		}
//		return "Updated : - "+updateDriver.toString()+" ";
//	}
////	
////	@PutMapping("/update/{driverId}")
////	public String updatedDriver(@PathVariable int driverId) throws DriverNotFoundException 
////	{
////		Driver updatedDriver = driverService.viewDriver(driverId);
////	return updatedDriver.toString();
////	}
//	
//	private Object updateDriver() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@DeleteMapping("/delete/{driverId}")
//	public List<Driver> deleteDriver(@PathVariable int driverId) throws DriverNotFoundException {
//		List<Driver> d = null;
//		try {
//			d = driverService.deleteDriver(driverId);
//		} catch (Exception e) {
//			throw new DriverNotFoundException("Driver with Id: " + driverId + " Not Found To Delete!");
//		}
//		return d;
//	}
//	
//	 @GetMapping("/bestdrivers")
//	 public List<Driver> viewBestDrivers() throws DriverNotFoundException {
//	  List<Driver> lis = null;
//	  try {
//	   lis = driverService.viewBestDrivers();
//	  } catch (Exception e) {
//	   throw new DriverNotFoundException("Best Drivers List is Empty");
//	  }
//	  return lis;
//	 }
//	 
//	 @GetMapping("/{driverId}")
//		public Driver viewDriver(@PathVariable int driverId) throws DriverNotFoundException {
//			Driver driver = null;
//			try {
//				driver = driverService.viewDriver(driverId);
//			} catch (Exception e) {
//				throw new DriverNotFoundException("Driver with Id: " + driverId + " Not Found!");
//			}
//			return driver;
//		}
//	 
//	/*@GetMapping("basedOnExperience/{experience}")
//		public Driver getDriverByExperience(@PathVariable int experience) throws DriverNotFoundException {
//		 List<Driver> exp = null;
//			try {
//				exp = driverService.getDriverByExperience(experience);
//		} catch (Exception e) {
//				throw new DriverNotFoundException("Driver with experience: " + experience + " Not Found!");
//			}
//			return (Driver) exp;
//		}*/
//
//
//}
