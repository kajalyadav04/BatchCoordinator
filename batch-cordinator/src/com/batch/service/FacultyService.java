package com.batch.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.batch.entity.Faculty;
import com.batch.exception.DuplicateEntryException;
import com.batch.exception.NullException;
import com.batch.exception.WrongUserDetailsException;

public interface FacultyService {
	public void adminViewAllFac(Map<String , Faculty> faculty) throws NullException ;
	public void signUp(Faculty fac , Map<String , Faculty> faculty) throws IOException, DuplicateEntryException;
	public boolean login(String id , String name ,String mail , String password, Map<String, Faculty> faculty) throws WrongUserDetailsException;

}
