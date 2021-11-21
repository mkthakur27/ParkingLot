package services;

import exception.InvalidTicketIdException;
import model.Slot;
import model.Ticket;
import repositories.IticketRepo;
import repositories.TicketRepoImpl;
import java.util.Date;

public class TicketService implements IticketService {

	private IticketRepo ticketRepo = TicketRepoImpl.getInstance();

	public String generateTicketId(String parkingLotId, Slot slot) {
		return parkingLotId + "_" + Integer.toString(slot.getFloor_number()) + "_"
				+ Integer.toString(slot.getSerialNumber());
	}

	@Override
	public void saveTicket(Ticket ticket) {
		ticketRepo.save(ticket);
	}

	@Override
	public Ticket getTicket(String ticketId) throws InvalidTicketIdException {
		// TODO Auto-generated method stub
		Ticket ticket = ticketRepo.find(ticketId);
		return ticket;
	}

	@Override
	public int getParkingCost(Ticket ticket) {
		// TODO Auto-generated method stub
		Date outTime = new Date();
		Date inTime = ticket.getInTime();
		long difference_In_Time = outTime.getTime() - inTime.getTime();
		long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;
		return (int) (difference_In_Hours * 10);
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		ticketRepo.delete(ticket);
	}
}
