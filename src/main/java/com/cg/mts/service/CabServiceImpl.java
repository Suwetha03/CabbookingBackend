package com.cg.mts.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Cab;
import com.cg.mts.repository.ICabRepository;

@Service
public class CabServiceImpl implements ICabService {
	
	
	@Autowired
	ICabRepository cabrepository;
	
	@Override
	public Cab insertCab(Cab cab) {
		
			return cabrepository.save(cab);
		
	}
	
	@Override
	public Cab updateCab(Cab cab, int id) {
		
			return cabrepository.save(cab);
		
	}

	@Override
	public List<Cab> getAllCab() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteCabbycabId(int cabId) {
		// TODO Auto-generated method stub
		
	}
}
