package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import exception.InvalidTicketIdException;
import exception.NoFreeSlotFoundException;
import exception.ParkingLotNotInitialisedException;
import model.ParkingLot;
import model.Slot;
import model.Ticket;
import model.VehichleType;
import model.Vehicle;
import utils.Constant;

public class ParkingServiceImpl implements IparkingService {

	private ParkingLot parkinglot = ParkingLot.getinstance();
	private IticketService ticketService = new TicketService();

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
		parkinglot.setTotalTruckSlots(Constant.TOTAL_SLOT_PER_FLOOR_TRUCK * floors);
		addSlot(VehichleType.TRUCK, Constant.START_SLOT_TRUCK, Constant.TOTAL_SLOT_PER_FLOOR_TRUCK, floors);
	}

	private void addBikeSlots(int floors) {
		parkinglot.setTotalBikeSlots(Constant.TOTAL_SLOT_PER_FLOOR_BIKE * floors);
		addSlot(VehichleType.BIKE, Constant.START_SLOT_BIKE, Constant.TOTAL_SLOT_PER_FLOOR_BIKE, floors);
	}

	private void addCarSlots(int floors, int slotsPerFloor) {
		int totalCarSlotsPerFloor = slotsPerFloor
				- (Constant.TOTAL_SLOT_PER_FLOOR_TRUCK + Constant.TOTAL_SLOT_PER_FLOOR_BIKE);
		parkinglot.setTotalCarSlots(floors * totalCarSlotsPerFloor);
		addSlot(VehichleType.CAR, Constant.START_SLOT_CAR, totalCarSlotsPerFloor, floors);
	}

	public void createParkingLot(String id, int floor, int slotsPerFloor) {
		parkinglot.init(id, floor, slotsPerFloor);
		addTruckSlots(floor);
		addBikeSlots(floor);
		addCarSlots(floor, slotsPerFloor);
	}

	@Override
	public void displayFreeSlots(VehichleType vehicleType) throws ParkingLotNotInitialisedException {
		Map<Integer, List<Slot>> slots = parkinglot.getSlots();
		if (slots.isEmpty() || slots == null) {
			throw new ParkingLotNotInitialisedException("parking lot is not intialised");
		}
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
					+ Integer.toString(entity.getKey()) + " : " + freeSlots + "\n";
		}
		System.out.println(displayString);

	}

	@Override
	public Ticket parkVehicle(String plateNumber, String color, VehichleType vehicleType)
			throws NoFreeSlotFoundException, ParkingLotNotInitialisedException {

		Slot slot = getFreeSlot(vehicleType);
		if (slot == null) {
			throw new NoFreeSlotFoundException("Slot is not available");
		}
		slot.setAvailable(false);
		Vehicle vehicle = new Vehicle(plateNumber, color);
		String ticketId = ticketService.generateTicketId(parkinglot.getId(), slot);
		Date currTime = new Date();
		Ticket ticket = new Ticket(ticketId, vehicle, slot, currTime);
		ticketService.saveTicket(ticket);
		return ticket;
	}

	private Slot getFreeSlot(VehichleType vehicleType) throws ParkingLotNotInitialisedException {
		if (parkinglot.getSlots().isEmpty()) {
			throw new ParkingLotNotInitialisedException("parking lot is not intialised");
		}
		for (Entry<Integer, List<Slot>> entity : parkinglot.getSlots().entrySet()) {
			for (Slot slot : entity.getValue()) {
				if (slot.getVehicleType().equals(vehicleType) && slot.isAvailable()) {
					return slot;
				}
			}
		}
		return null;
	}

	@Override
	public void displayOccupiedSlots(VehichleType vehicleType) throws ParkingLotNotInitialisedException {
		// TODO Auto-generated method stub
		Map<Integer, List<Slot>> slots = parkinglot.getSlots();
		if (slots.isEmpty() || slots == null) {
			throw new ParkingLotNotInitialisedException("parking lot is not intialised");
		}
		String displayString = "";
		for (Map.Entry<Integer, List<Slot>> entity : slots.entrySet()) {
			String freeSlots = "";
			for (Slot slot : entity.getValue()) {
				if (!slot.isAvailable() && slot.getVehicleType().equals(vehicleType))
					if (slot.getSerialNumber() != parkinglot.getSlotsPerFloor()) {
						freeSlots += Integer.toString(slot.getSerialNumber()) + ", ";
					} else {
						freeSlots += Integer.toString(slot.getSerialNumber());
					}
			}
			displayString += "Occupied Slots for " + vehicleType.toString() + " on Floor "
					+ Integer.toString(entity.getKey()) + " : " + freeSlots + "\n";
		}
		System.out.println(displayString);

	}

	@Override
	public void unParkVehicle(String ticketId) {
		// TODO Auto-generated method stub
		try {
			Ticket ticket = ticketService.getTicket(ticketId);
			Slot slot = ticket.getSlot();
			slot.setAvailable(true);
			Vehicle vehicle = ticket.getVehicle();
			int cost = ticketService.getParkingCost(ticket);
			System.out.println("Unparked vehicle with Registration Number: " + vehicle.getPlateNumber() + " and Color: "
					+ vehicle.getColor() + " total cost: " + cost);
			ticketService.deleteTicket(ticket);

		} catch (InvalidTicketIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
