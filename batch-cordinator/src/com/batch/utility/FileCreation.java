package com.batch.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import com.batch.entity.Batches;
import com.batch.entity.Faculty;

public class FileCreation {
	public static Map<String, Batches> batches(){
		Map<String, Batches> batchfileMap = null;
		File f = new File("batches.ser");
		Boolean flag=false;
		try {
			
			if(!f.exists()) {
				f.createNewFile();
				flag=true;
			}
			if(flag) {
				batchfileMap = new LinkedHashMap<>();
				ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(f));
				stream.writeObject(batchfileMap);
			}
			else {
				ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(f));
				batchfileMap=(Map<String, Batches>)inputStream.readObject();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return batchfileMap;
	}
	public static Map<String, Faculty> faculty(){
		Map<String, Faculty> facultyfileMap = null;
		File f = new File("faculty.ser");
		Boolean flag=false;
		try {
			
			if(!f.exists()) {
				f.createNewFile();
				flag=true;
			}
			if(flag) {
				facultyfileMap = new LinkedHashMap<>();
				ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(f));
				stream.writeObject(facultyfileMap);
			}
			else {
				ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(f));
				facultyfileMap=(Map<String, Faculty>)inputStream.readObject();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return facultyfileMap;
	}

}
