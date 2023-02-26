package com.cg.mts.controller;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.mts.dto.CabDTODefaultResponse;
import com.cg.mts.entities.Cab;
import com.cg.mts.exception.CabNotFoundException;
import com.cg.mts.service.ICabService;
import com.cg.mts.util.CabDTOConvertor;

import java.util.List;;

@RestController
@RequestMapping("/api/cab")
public class CabController {
	
	@Autowired
	private ICabService iCabService;
	@Autowired
	CabDTOConvertor dtoConvertor;
	
	@GetMapping("/list")
	public ResponseEntity<List<CabDTODefaultResponse>> getAllStud()
	{
		List<Cab> allCabsInDB = iCabService.getAllCab();
		
		List<CabDTODefaultResponse> dtoList = new ArrayList<>();
		for (Cab cab : allCabsInDB) {
			
			CabDTODefaultResponse dtoObj = dtoConvertor.convertTo(cab);
			dtoList.add(dtoObj);
		}
		
		return new ResponseEntity<List<CabDTODefaultResponse>>(dtoList,HttpStatus.OK);
	}
	

	@PostMapping("/insertcab")
	public Cab insertCab( @RequestBody Cab cab) {
		return iCabService.insertCab(cab);
	}

	/*@PutMapping("/updatecab/{cabId}/price/{perKmRate}")
	public <CabDTODefaultResponse>  Cab updateCab( @RequestBody Cab cab, @PathVariable int cabId, @PathVariable int perKmRate) {
		
		return iCabService.updateCab(cab, cabId, perKmRate);
	}*/
	
	@PutMapping("/updatecab/{cabId}/price/{perKmRate}")
	public String updateCabWithperKmRate(@RequestBody Cab cab, @PathVariable int cabId, @PathVariable int perKmRate)
	{
		Cab updateCab = iCabService.updateCab(cab, perKmRate);
		
		if(updateCab() != null)
		{
			return updateCab.toString();
		}
		return "Updated : - "+updateCab.toString()+" ";
	}

	private Object updateCab() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@DeleteMapping("/{cabId}")
	public void removeCab(@PathVariable int cabId) throws CabNotFoundException {
		iCabService.DeleteCabbycabId(cabId);
	}
	
	

}
