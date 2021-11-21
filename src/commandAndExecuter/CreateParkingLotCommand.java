package commandAndExecuter;

import services.IparkingService;
import services.ParkingServiceImpl;

public class CreateParkingLotCommand implements Command {

	private String command;
	private IparkingService parkingService = new ParkingServiceImpl();

	public CreateParkingLotCommand(String cmd) {
		this.command = cmd;
	}

	@Override
	public void execute() {
		String[] commands = command.split(" ");
		System.out.println("Creating Parking lot");
		String parkingId = commands[1];
		String floor = commands[2];
		String numberOfSlotPerFloor = commands[3];
		parkingService.createParkingLot(parkingId, Integer.parseInt(floor), Integer.parseInt(numberOfSlotPerFloor));
		System.out.println("Created parking lot with " + floor + " floors and " + numberOfSlotPerFloor
				+ " number of slots per floor");
	}

}
