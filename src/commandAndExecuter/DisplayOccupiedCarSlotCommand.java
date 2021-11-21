package commandAndExecuter;

import exception.ParkingLotNotInitialisedException;
import model.VehichleType;
import services.IparkingService;
import services.ParkingServiceImpl;

public class DisplayOccupiedCarSlotCommand implements Command {

	private IparkingService parkingService = new ParkingServiceImpl();
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try {
			parkingService.displayOccupiedSlots(VehichleType.CAR);
		} catch (ParkingLotNotInitialisedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
