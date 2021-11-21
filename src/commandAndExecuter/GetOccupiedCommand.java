package commandAndExecuter;

import commandFactoryPackage.CommandFactory;

public class GetOccupiedCommand implements Command {

	String command;
	public GetOccupiedCommand(String command) {
		// TODO Auto-generated constructor stub
		this.command = command;
	}
	@Override
	public void execute() {
		Command cmd = CommandFactory.displayOccupiedSlotCommand(command);
		cmd.execute();
		// TODO Auto-generated method stub
	}

}
