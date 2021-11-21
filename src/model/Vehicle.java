package model;

public class Vehicle {
	private static int id=0;
	private String plateNumber;
	private String color;
	public Vehicle(String plateNumber, String color) {
		super();
		this.plateNumber = plateNumber;
		this.color = color;
		id += 1;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
