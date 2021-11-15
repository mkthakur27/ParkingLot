package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.ParkingLotInitException;

public class ParkingLot {

	private String id;
	private int numberOfFloors;
	private int slotsPerFloor;
	private Map<Integer, List<Slot>> slots;
	private int totalCarSlots;
	private int totalBikeSlots;
	private int totalTruckSlots;
	private Map<Integer,Integer> occupiedCarSlots;
	private Map<Integer,Integer> occupiedBikeSlots;
	private Map<Integer,Integer> occupiedTruckSlots;
	private static ParkingLot parkingLot = null;

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public Map<Integer, List<Slot>> getSlots() {
		return slots;
	}

	public void setSlots(Map<Integer, List<Slot>> slots) {
		this.slots = slots;
	}

	public int getTotalCarSlots() {
		return totalCarSlots;
	}

	public void setTotalCarSlots(int totalCarSlots) {
		this.totalCarSlots = totalCarSlots;
	}

	public int getTotalBikeSlots() {
		return totalBikeSlots;
	}

	public void setTotalBikeSlots(int totalBikeSlots) {
		this.totalBikeSlots = totalBikeSlots;
	}

	public int getTotalTruckSlots() {
		return totalTruckSlots;
	}

	public void setTotalTruckSlots(int totalTruckSlots) {
		this.totalTruckSlots = totalTruckSlots;
	}

	public Map<Integer, Integer> getOccupiedCarSlots() {
		return occupiedCarSlots;
	}

	public void setOccupiedCarSlots(Map<Integer, Integer> occupiedCarSlots) {
		this.occupiedCarSlots = occupiedCarSlots;
	}

	public Map<Integer, Integer> getOccupiedBikeSlots() {
		return occupiedBikeSlots;
	}

	public void setOccupiedBikeSlots(Map<Integer, Integer> occupiedBikeSlots) {
		this.occupiedBikeSlots = occupiedBikeSlots;
	}

	public Map<Integer, Integer> getOccupiedTruckSlots() {
		return occupiedTruckSlots;
	}

	public void setOccupiedTruckSlots(Map<Integer, Integer> occupiedTruckSlots) {
		this.occupiedTruckSlots = occupiedTruckSlots;
	}

	public static ParkingLot getinstance() {
		if (parkingLot == null)
		{
			parkingLot = new ParkingLot();
		}
		return parkingLot;
	}

	private ParkingLot() {
		slots = new HashMap<>();
		occupiedCarSlots = new HashMap<>();
		occupiedBikeSlots = new HashMap<>();
		occupiedCarSlots = new HashMap<>();
	}

	public void init(String id, int numberOfFloors, int slootsPerFloor){
		if (parkingLot == null) {
			parkingLot = new ParkingLot();
		}
		this.id = id;
		this.numberOfFloors = numberOfFloors;
		this.slotsPerFloor = slootsPerFloor;
	}

	public int getSlotsPerFloor() {
		return slotsPerFloor;
	}

	public void setSlotsPerFloor(int slotsPerFloor) {
		this.slotsPerFloor = slotsPerFloor;
	}
}
