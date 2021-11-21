package commandAndExecuter;

import exception.NoFreeSlotFoundException;
import exception.ParkingLotNotInitialisedException;
import model.Ticket;
import model.VehichleType;
import services.IparkingService;
import services.ParkingServiceImpl;

public class ParkCarCommand implements Command {

	private String command = "";
	private IparkingService parkingService = new ParkingServiceImpl();

	public ParkCarCommand(String command) {
		this.command = command;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		String commands[] = command.split(" ");
		try {
			String plateNumber = commands[2];
			String color = commands[3];
			Ticket ticket = parkingService.parkVehicle(plateNumber, color, VehichleType.CAR);
			System.out.println("Parked vehicle. Ticket ID: " + ticket.getId());
		} catch (NoFreeSlotFoundException | ParkingLotNotInitialisedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
