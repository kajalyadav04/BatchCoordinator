package com.batch.service;

import java.util.Map;

import com.batch.entity.Batches;
import com.batch.entity.Faculty;
import com.batch.exception.NullException;
import com.masai.exceptions.DuplicateEntryException;

public interface BatchesService {
	public void batchesViewAll(Map<String , Batches> batches) throws NullException ;
	public String createNewBatch(Map<String , Batches> batches , Batches newBatch);


}
