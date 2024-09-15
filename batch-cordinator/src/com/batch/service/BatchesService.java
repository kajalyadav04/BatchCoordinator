package com.batch.service;

import java.util.Map;

import com.batch.entity.Batches;
import com.batch.entity.Faculty;
import com.batch.exception.NullException;

public interface BatchesService {
	public void batchesViewAll(Map<String , Batches> batches) throws NullException ;


}
