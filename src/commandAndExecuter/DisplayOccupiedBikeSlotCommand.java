package commandAndExecuter;

import model.VehichleType;
import services.IparkingService;
import services.ParkingServiceImpl;

public class DisplayOccupiedBikeSlotCommand implements Command {

	private IparkingService parkingService = new ParkingServiceImpl();
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try
		{
			parkingService.displayOccupiedSlots(VehichleType.BIKE);
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}

	}

}
