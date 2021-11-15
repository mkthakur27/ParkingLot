package commandAndExecuter;

import model.VehichleType;
import services.IparkingService;
import services.ParkingServiceImpl;

public class DisplayFreeBikeSlotCommand implements Command {

	private IparkingService parkingService = new ParkingServiceImpl();

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		parkingService.displayFreeSlots(VehichleType.BIKE);
	}

}
