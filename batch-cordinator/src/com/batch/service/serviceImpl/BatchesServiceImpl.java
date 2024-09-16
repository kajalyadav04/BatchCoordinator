package com.batch.service.serviceImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.batch.entity.Batches;
import com.batch.entity.Faculty;
import com.batch.exception.DuplicateEntryException;
import com.batch.exception.EmptyListException;
import com.batch.exception.NullException;
import com.batch.service.BatchesService;

public class BatchesServiceImpl implements BatchesService{

	@Override
	public void batchesViewAll(Map<String, Batches> batches) throws NullException {
		// TODO Auto-generated method stub
		if(batches!=null&&batches.size()>0) {
			for(Map.Entry<String, Batches> entry : batches.entrySet()) {
				System.out.println(entry.getValue());
				
			}
		}
		else {
			throw new NullException("batches empty please add batches");
		}
		
	}

	@Override
	public String createNewBatch(Map<String, Batches> batcheMap, Batches newBatch) throws DuplicateEntryException {
		if(!batcheMap.containsKey(newBatch.getId())) {
			batcheMap.put(newBatch.getId(), newBatch);
			ObjectOutputStream batchSt;
			try {
				batchSt = new ObjectOutputStream(new FileOutputStream("BatchFile.ser"));
				batchSt.writeObject(batcheMap);
			} catch ( IOException e) {
				System.out.println(e.getMessage());
			}
		}else {
			throw new DuplicateEntryException("This Batch has already been created , create a new one");
		}
			
		// TODO Auto-generated method stub
		return "Batch with ID: "+newBatch.getId()+" has Successfully been Created";
	}

	@Override
	public Batches viewABatchById(String id, Map<String, Batches> batches) throws EmptyListException {
		if(batches.size()==0) throw new EmptyListException("No Any Batches is present, first create one...");
		if(batches.containsKey(id)) {
			Batches batch = batches.get(id);
//			System.out.println(batch);
			return batch;
		}else {
			throw new EmptyListException("Given id is not present in the database");
		}
	}
		
	

}
