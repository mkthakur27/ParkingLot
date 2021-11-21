package commandAndExecuter;

import commandFactoryPackage.CommandFactory;

public class ParkVehicleCommand implements Command {

	private String command;
	public ParkVehicleCommand(String cmd)
	{
		this.command = cmd;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Command cmd = CommandFactory.getparkVehicleCommand(command);
		cmd.execute();

	}

}
