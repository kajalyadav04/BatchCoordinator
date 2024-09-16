package com.batch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Batches implements Serializable {
	private String id;
	private String courseName;
	private int noOfSeats;
	
	private String startDate;
	private int duration; 
	private String endDate;
	private String faculty;
	public Batches(String id, String courseName, int noOfSeats, String startDate, int duration) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.noOfSeats = noOfSeats;
		this.startDate = startDate;
		this.duration = duration;
		this.endDate = endDateCalculate( startDate, duration);
	}
	private String endDateCalculate(String startDate2, int duration2) {
		DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate lDate = LocalDate.parse(startDate2,dtFormatter);
		LocalDate enDate = lDate.plus(duration2, ChronoUnit.MONTHS);
		// TODO Auto-generated method stub
		return String.valueOf(enDate);
	}
	public Batches() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	@Override
	public String toString() {
		return "Batches [id=" + id + ", courseName=" + courseName + ", noOfSeats=" + noOfSeats + ", startDate="
				+ startDate + ", duration=" + duration + ", endDate=" + endDate + ", faculty=" + faculty + "]";
	}
	

}
