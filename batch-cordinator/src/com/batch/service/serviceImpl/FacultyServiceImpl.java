package com.batch.service.serviceImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.batch.entity.Faculty;
import com.batch.exception.DuplicateEntryException;
import com.batch.exception.NullException;
import com.batch.exception.WrongUserDetailsException;
import com.batch.service.FacultyService;

public class FacultyServiceImpl implements FacultyService {

	@Override
	public void adminViewAllFac(Map<String, Faculty> faculty) throws NullException {
		if(faculty!=null&&faculty.size()>0) {
			for(Map.Entry<String, Faculty> entry : faculty.entrySet()) {
				System.out.println(entry.getValue());
				
			}
		}
		else {
			throw new NullException("Faculty empty please add faculty");
		}
		
	}

	@Override
	public void signUp(Faculty fac, Map<String, Faculty> faculty) throws IOException, DuplicateEntryException {
		if(faculty.containsKey(fac.getFacId())) {
			throw new DuplicateEntryException("This  with ID: "+fac.getFacId()+" is Already Registered, Register another Faculty");
		}
		else {
			faculty.put(fac.getFacId(), fac);
			System.out.println("Faculty has Successfully been SignedUp.. "+"\n"+"Here are Details ");
			System.out.println(fac);
			ObjectOutputStream facultySt = new ObjectOutputStream(new FileOutputStream("Faculty.ser"));
			facultySt.writeObject(faculty);
			facultySt.close();
		}
	}

	@Override
	public boolean login(String id, String name, String mail, String password, Map<String, Faculty> faculty) throws WrongUserDetailsException {
		if(faculty.containsKey(id)) {

			if(faculty.get(id).getPassword().equals(password)) {
				return true;
			}else {
				throw new WrongUserDetailsException("You've Entered Wrong Credentials! Try Again...");
			}

		}
		else {
			throw new WrongUserDetailsException("Faculty is not registered! Register First...");
		}
	}


}
