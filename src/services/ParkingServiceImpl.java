package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.ParkingLot;
import model.Slot;
import model.VehichleType;
import utils.Contant;

public class ParkingServiceImpl implements IparkingService {

	private ParkingLot parkinglot = ParkingLot.getinstance();

	public ParkingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	private void addSlot(VehichleType vehicleType, int startSlot, int numberOfSlotsPerFloor, int floors) {
		Map<Integer, List<Slot>> allSlots = parkinglot.getSlots();
		if (allSlots == null) {
			allSlots = new HashMap<>();
		}
		for (int floor = 1; floor <= floors; floor++) {
			List<Slot> slots = allSlots.get(floor);
			if (slots == null) {
				slots = new ArrayList<>();
			}
			for (int slotNumber = startSlot; slotNumber < startSlot + numberOfSlotsPerFloor; slotNumber++) {
				Slot newTruckSlot = new Slot(slotNumber, vehicleType, floor);
				slots.add(newTruckSlot);
			}
			allSlots.put(floor, slots);
		}
		parkinglot.setSlots(allSlots);
	}

	private void addTruckSlots(int floors) {
		parkinglot.setTotalTruckSlots(Contant.TOTAL_SLOT_PER_FLOOR_TRUCK * floors);
		addSlot(VehichleType.TRUCK, Contant.START_SLOT_TRUCK, Contant.TOTAL_SLOT_PER_FLOOR_TRUCK, floors);
	}

	private void addBikeSlots(int floors) {
		parkinglot.setTotalBikeSlots(Contant.TOTAL_SLOT_PER_FLOOR_BIKE * floors);
		addSlot(VehichleType.BIKE, Contant.START_SLOT_BIKE, Contant.TOTAL_SLOT_PER_FLOOR_BIKE, floors);
	}

	private void addCarSlots(int floors, int slotsPerFloor) {
		int totalCarSlotsPerFloor = slotsPerFloor
				- (Contant.TOTAL_SLOT_PER_FLOOR_TRUCK + Contant.TOTAL_SLOT_PER_FLOOR_BIKE);
		parkinglot.setTotalCarSlots(floors * totalCarSlotsPerFloor);
		addSlot(VehichleType.CAR, Contant.START_SLOT_CAR, totalCarSlotsPerFloor, floors);
	}

	public void createParkingLot(String id, int floor, int slotsPerFloor) {
		parkinglot.init(id, floor, slotsPerFloor);
		addTruckSlots(floor);
		addBikeSlots(floor);
		addCarSlots(floor, slotsPerFloor);
	}

	@Override
	public void displayFreeSlots(VehichleType vehicleType) {
		Map<Integer, List<Slot>> slots = parkinglot.getSlots();
		String displayString = "";
		for (Map.Entry<Integer, List<Slot>> entity : slots.entrySet()) {
			String freeSlots = "";
			for (Slot slot : entity.getValue()) {
				if (slot.isAvailable() && slot.getVehicleType().equals(vehicleType))
					if (slot.getSerialNumber() != parkinglot.getSlotsPerFloor()) {
						freeSlots += Integer.toString(slot.getSerialNumber()) + ", ";
					} else {
						freeSlots += Integer.toString(slot.getSerialNumber());
					}
			}
			displayString += "Free Slots for " + vehicleType.toString() + " on Floor "
					+ Integer.toString(entity.getKey()) + " : " + freeSlots +"\n";
		}
		System.out.println(displayString);

	}
}
