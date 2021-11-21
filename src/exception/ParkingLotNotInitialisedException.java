package exception;

public class ParkingLotNotInitialisedException extends Exception {
	public ParkingLotNotInitialisedException(String errorMessage) {
		super(errorMessage);
	}
}
