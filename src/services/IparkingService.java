package services;

import exception.NoFreeSlotFoundException;
import exception.ParkingLotNotInitialisedException;
import model.Ticket;
import model.VehichleType;

public interface IparkingService {

	public void createParkingLot(String id, int floor, int slotsPerFloor);

	public void displayFreeSlots(VehichleType vehicleType) throws ParkingLotNotInitialisedException;

	public Ticket parkVehicle(String plateNumber, String color, VehichleType vehicleType)
			throws NoFreeSlotFoundException, ParkingLotNotInitialisedException;

	public void displayOccupiedSlots(VehichleType vehicleType) throws ParkingLotNotInitialisedException;

	public void unParkVehicle(String ticketId);
}
