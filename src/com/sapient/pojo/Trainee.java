package com.sapient.pojo;

import java.util.Date;

public class Trainee {
	private String traineeName;
	private String traineeContact;
	private Address traineeCurAddr;
	private Address traineePerAddr;
	private String traineeStream;
	private Date traineeJoinDate;
	private int traineeScore;
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeContact() {
		return traineeContact;
	}
	public void setTraineeContact(String traineeContact) {
		this.traineeContact = traineeContact;
	}
	public Address getTraineeCurAddr() {
		return traineeCurAddr;
	}
	public void setTraineeCurAddr(Address traineeCurAddr) {
		this.traineeCurAddr = traineeCurAddr;
	}
	public Address getTraineePerAddr() {
		return traineePerAddr;
	}
	public void setTraineePerAddr(Address traineePerAddr) {
		this.traineePerAddr = traineePerAddr;
	}
	public String getTraineeStream() {
		return traineeStream;
	}
	public void setTraineeStream(String traineeStream) {
		this.traineeStream = traineeStream;
	}
	public Date getTraineeJoinDate() {
		return traineeJoinDate;
	}
	public void setTraineeJoinDate(Date traineeJoinDate) {
		this.traineeJoinDate = traineeJoinDate;
	}
	public int getTraineeScore() {
		return traineeScore;
	}
	public void setTraineeScore(int traineeScore) {
		this.traineeScore = traineeScore;
	}
	public Trainee() {
	}
	
	
	public Trainee(String traineeName, String traineeContact,
			Address traineeCurAddr, Address traineePerAddr,
			String traineeStream, Date traineeJoinDate, int traineeScore) {
		this.traineeName = traineeName;
		this.traineeContact = traineeContact;
		this.traineeCurAddr = traineeCurAddr;
		this.traineePerAddr = traineePerAddr;
		this.traineeStream = traineeStream;
		this.traineeJoinDate = traineeJoinDate;
		this.traineeScore = traineeScore;
	}
	@Override
	public String toString() {
		return "Trainee [traineeName=" + traineeName + ", traineeContact="
				+ traineeContact + ", traineeCurAddr=" + traineeCurAddr
				+ ", traineePerAddr=" + traineePerAddr + ", traineeStream="
				+ traineeStream + ", traineeJoinDate=" + traineeJoinDate
				+ ", traineeScore=" + traineeScore + "]";
	}
	
	
}
