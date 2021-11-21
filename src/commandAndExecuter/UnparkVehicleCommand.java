package commandAndExecuter;

import services.IparkingService;
import services.ParkingServiceImpl;

public class UnparkVehicleCommand implements Command {

	String command="";
	private IparkingService parkingService = new ParkingServiceImpl();
	public UnparkVehicleCommand(String command) {
		this.command = command;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String commands[] = command.split(" ");
		String ticketId = commands[1];
		parkingService.unParkVehicle(ticketId);
	}

}
