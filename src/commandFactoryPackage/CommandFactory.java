package commandFactoryPackage;

import commandAndExecuter.Command;
import commandAndExecuter.CreateParkingLotCommand;
import commandAndExecuter.DisplayCommand;
import commandAndExecuter.DisplayFreeBikeCountCommand;
import commandAndExecuter.DisplayFreeBikeSlotCommand;
import commandAndExecuter.DisplayFreeCarCountCommand;
import commandAndExecuter.DisplayFreeCarSlotCommand;
import commandAndExecuter.DisplayFreeTruckCountCommand;
import commandAndExecuter.DisplayFreeTruckSlotCommand;
import commandAndExecuter.DisplayOccupiedBikeSlotCommand;
import commandAndExecuter.DisplayOccupiedCarSlotCommand;
import commandAndExecuter.DisplayOccupiedTruckSlotCommand;
import commandAndExecuter.GetFreeCountCommand;
import commandAndExecuter.GetFreeSlotCommand;
import commandAndExecuter.GetOccupiedCommand;
import commandAndExecuter.ParkBikeCommand;
import commandAndExecuter.ParkCarCommand;
import commandAndExecuter.ParkTruckCommand;
import commandAndExecuter.ParkVehicleCommand;
import commandAndExecuter.UnparkBikeCommand;
import commandAndExecuter.UnparkCarCommand;
import commandAndExecuter.UnparkTruckCommand;
import commandAndExecuter.UnparkVehicleCommand;

public class CommandFactory {
	
	public  static Command getInitialCommand(String cmd) {
		// TODO Auto-generated method stub
		String[] commands = cmd.split(" ");
		switch(commands[0])
		{
		case "display":
			return new DisplayCommand(cmd);
		case "create_parking_lot":
			return new CreateParkingLotCommand(cmd);
		case "park_vehicle":
			return new ParkVehicleCommand(cmd);
		case "unpark_vehicle":
			return new UnparkVehicleCommand(cmd);
		default:
			System.out.println("Please provide valid command");
		}
		return null;
	}

	public static Command getDisplayCommand(String command) {
		// TODO Auto-generated method stub
		String[] commands = command.split(" ");
		switch(commands[1])
		{
		case "occupied_slots":
			return new GetOccupiedCommand(command);
		case "free_slots":
			return new GetFreeSlotCommand(command);
		case "free_count":
			return new GetFreeCountCommand(command);
		default:
			System.out.println("Please provide valid command");
		}
		return null;
	}
	
	public static Command displayFreeSlotCommand(String command)
	{
		String[] commands = command.split(" ");
		switch(commands[2])
		{
		case "CAR":
			return new DisplayFreeCarSlotCommand();
		case "BIKE":
			return new DisplayFreeBikeSlotCommand();
		case "TRUCK":
			return new DisplayFreeTruckSlotCommand();
		default:
			System.out.println("Please provide valid command");
		}
		return null;
	}
	
	public static Command displayOccupiedSlotCommand(String command)
	{
		String[] commands = command.split(" ");
		switch(commands[2])
		{
		case "CAR":
			return new DisplayOccupiedCarSlotCommand();
		case "BIKE":
			return new DisplayOccupiedBikeSlotCommand();
		case "TRUCK":
			return new DisplayOccupiedTruckSlotCommand();
		default:
			System.out.println("Please provide valid command");
		}
		return null;
	}
	
	public static Command displayFreeCountCommand(String command)
	{
		String[] commands = command.split(" ");
		switch(commands[2])
		{
		case "CAR":
			return new DisplayFreeCarCountCommand();
		case "BIKE":
			return new DisplayFreeBikeCountCommand();
		case "TRUCK":
			return new DisplayFreeTruckCountCommand();
		default:
			System.out.println("Please provide valid command");
		}
		return null;
	}
	
	public static Command parkVehicleCommand(String command)
	{
		String[] commands = command.split(" ");
		switch(commands[2])
		{
		case "CAR":
			return new ParkCarCommand(command);
		case "BIKE":
			return new ParkBikeCommand(command);
		case "TRUCK":
			return new ParkTruckCommand(command);
		default:
			System.out.println("Please provide valid command");
		}
		return null;
	}
	
	public static Command unparkVehicleCommand(String command)
	{
		String[] commands = command.split(" ");
		switch(commands[2])
		{
		case "CAR":
			return new UnparkCarCommand(command);
		case "BIKE":
			return new UnparkBikeCommand(command);
		case "TRUCK":
			return new UnparkTruckCommand(command);
		default:
			System.out.println("Please provide valid command");
		}
		return null;
	}
	

}
