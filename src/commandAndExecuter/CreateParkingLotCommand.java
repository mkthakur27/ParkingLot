package commandAndExecuter;

import services.IparkingService;
import services.ParkingServiceImpl;

public class CreateParkingLotCommand implements Command {

	private String command;
	private IparkingService parkingService = new ParkingServiceImpl();
	public CreateParkingLotCommand(String cmd)
	{
		this.command = cmd;
	}
	@Override
	public void execute() {
		String[] commands = command.split(" ");
		System.out.println("Creating Parking lot");
		parkingService.createParkingLot(commands[1],Integer.parseInt(commands[2]), Integer.parseInt(commands[3]));
		System.out.println("Parking service created sucessfully");
	}

}
