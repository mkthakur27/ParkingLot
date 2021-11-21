package model;

import java.util.Date;

public class Ticket {

	private String id;
	private Vehicle vehicle;
	private Slot slot;
	private Date inTime;
	private Date outTime;
	public Ticket(String id, Vehicle vehicle, Slot slot, Date inTime) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.slot = slot;
		this.inTime = inTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public Date getOutTime() {
		return outTime;
	}
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	
	
}
