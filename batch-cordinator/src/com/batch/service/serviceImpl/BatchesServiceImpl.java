package com.batch.service.serviceImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.batch.entity.Batches;
import com.batch.exception.DuplicateEntryException;
import com.batch.exception.NullException;
import com.batch.service.BatchesService;

public class BatchesServiceImpl implements BatchesService{

	@Override
	public void batchesViewAll(Map<String, Batches> batches) throws NullException {
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
	public String createNewBatch(Map<String, Batches> batches, Batches newBatch) throws DuplicateEntryException {
		if(!batches.containsKey(newBatch.getId())) {
			batches.put(newBatch.getId(), newBatch);
			ObjectOutputStream batchSt;
			try {
				batchSt = new ObjectOutputStream(new FileOutputStream("batches.ser"));
				batchSt.writeObject(batches);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			throw new DuplicateEntryException("This Batch has already been created , create a new one");
		}
			
		return "Batch with ID: "+newBatch.getId()+" has Successfully been Created";
	}
		
	

}
