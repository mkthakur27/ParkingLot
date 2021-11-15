package services;

import model.VehichleType;

public interface IparkingService {

	public void createParkingLot(String id, int floor, int slotsPerFloor);
	public void displayFreeSlots(VehichleType vehicleType);
}
