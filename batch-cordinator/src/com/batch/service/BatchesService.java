package com.batch.service;

import java.util.Map;

import com.batch.entity.Batches;
import com.batch.entity.Faculty;
import com.batch.exception.DuplicateEntryException;
import com.batch.exception.EmptyListException;
import com.batch.exception.NullException;

public interface BatchesService {
	public void batchesViewAll(Map<String , Batches> batches) throws NullException ;
	public String createNewBatch(Map<String , Batches> batcheMap , Batches newBatch) throws DuplicateEntryException ;
	public Batches viewABatchById(String id , Map<String  , Batches> batches)  throws EmptyListException;


}
