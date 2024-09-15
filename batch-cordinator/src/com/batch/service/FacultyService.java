package com.batch.service;

import java.util.Map;

import com.batch.entity.Faculty;
import com.batch.exception.NullException;

public interface FacultyService {
	public void adminViewAllFac(Map<String , Faculty> faculty) throws NullException ;

}
