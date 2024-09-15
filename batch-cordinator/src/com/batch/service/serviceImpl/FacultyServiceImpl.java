package com.batch.service.serviceImpl;

import java.util.Map;

import com.batch.entity.Faculty;
import com.batch.exception.NullException;
import com.batch.service.FacultyService;

public class FacultyServiceImpl implements FacultyService {

	@Override
	public void adminViewAllFac(Map<String, Faculty> faculty) throws NullException {
		// TODO Auto-generated method stub
		if(faculty!=null&&faculty.size()>0) {
			for(Map.Entry<String, Faculty> entry : faculty.entrySet()) {
				System.out.println(entry.getValue());
				
			}
		}
		else {
			throw new NullException("Faculty empty please add faculty");
		}
		
	}
	
	

}
