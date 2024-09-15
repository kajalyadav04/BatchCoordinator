package com.batch.service.serviceImpl;

import java.util.Map;

import com.batch.entity.Batches;
import com.batch.entity.Faculty;
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
		
	

}
