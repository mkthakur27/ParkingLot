package commandAndExecuter;

import exception.NoFreeSlotFoundException;
import exception.ParkingLotNotInitialisedException;
import model.Ticket;
import model.VehichleType;
import services.IparkingService;
import services.ParkingServiceImpl;

public class ParkBikeCommand implements Command {

	private String command = "";
	private IparkingService parkingService = new ParkingServiceImpl();

	public ParkBikeCommand(String command) {
		this.command = command;
	}

	@Override
	public void execute() {
		String commands[] = command.split(" ");
		try {
			String plateNumber = commands[2];
			String color = commands[3];
			Ticket ticket = parkingService.parkVehicle(plateNumber, color, VehichleType.BIKE);
			System.out.println("Parked vehicle. Ticket ID: " + ticket.getId());
		} catch (NoFreeSlotFoundException | ParkingLotNotInitialisedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
