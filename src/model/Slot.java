package model;

public class Slot {

	private static int id=1;
	private int serialNumber;
	private VehichleType vehicleType;
	private int floor_number;
	private boolean isAvailable;
	private Vehicle parkedVehicle;
	public Slot(int serialNumber, VehichleType vehicleType, int floor_number) {
		super();
		id++;
		this.serialNumber = serialNumber;
		this.vehicleType = vehicleType;
		this.floor_number = floor_number;
		isAvailable = true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public VehichleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehichleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getFloor_number() {
		return floor_number;
	}
	public void setFloor_number(int floor_number) {
		this.floor_number = floor_number;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Vehicle getParkedVehicle() {
		return parkedVehicle;
	}
	public void setParkedVehicle(Vehicle parkedVehicle) {
		this.parkedVehicle = parkedVehicle;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
}
