package commandAndExecuter;

import commandFactoryPackage.CommandFactory;

public class GetFreeSlotCommand implements Command {

	private String command;
	public GetFreeSlotCommand(String command) {
		this.command = command;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Command cmd = CommandFactory.displayFreeSlotCommand(command);
		cmd.execute();
	}

}
