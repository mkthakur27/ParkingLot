package commandAndExecuter;

import commandFactoryPackage.CommandFactory;

public class DisplayCommand implements Command {

	String command;
	public DisplayCommand(String command)
	{
		this.command = command;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Command cmd = CommandFactory.getDisplayCommand(command);
		cmd.execute();
	}

}
