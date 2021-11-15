package driverPackage;

import java.util.Scanner;

import commandAndExecuter.Command;
import commandFactoryPackage.CommandFactory;

public class MainDriver {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String command = sc.nextLine();
			if (command.equals("exit"))
			{
				System.out.println("Exit succesfully");
				break;
			}
			Command cmd = CommandFactory.getInitialCommand(command);
			if (cmd != null)
			{
				cmd.execute();
			}
			
		}
	}
}
