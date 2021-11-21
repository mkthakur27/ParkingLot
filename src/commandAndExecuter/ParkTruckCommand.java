package commandAndExecuter;

import exception.NoFreeSlotFoundException;
import exception.ParkingLotNotInitialisedException;
import model.Ticket;
import model.VehichleType;
import services.IparkingService;
import services.ParkingServiceImpl;

public class ParkTruckCommand implements Command {

	private String command = "";
	private IparkingService parkingService = new ParkingServiceImpl();

	public ParkTruckCommand(String command) {
		this.command = command;
	}

	@Override
	public void execute() {
		String commands[] = command.split(" ");

		try {
			String plateNumber = commands[2];
			String color = commands[3];
			Ticket ticket;
			ticket = parkingService.parkVehicle(plateNumber, color, VehichleType.TRUCK);
			System.out.println("Parked vehicle. Ticket ID: " + ticket.getId());
		} catch (NoFreeSlotFoundException | ParkingLotNotInitialisedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
