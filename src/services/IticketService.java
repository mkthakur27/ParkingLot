package services;

import exception.InvalidTicketIdException;
import model.Slot;
import model.Ticket;

public interface IticketService {

	public String generateTicketId(String parkingLotId, Slot slot);

	public void saveTicket(Ticket ticket);

	public Ticket getTicket(String ticketId) throws InvalidTicketIdException;

	public int getParkingCost(Ticket ticket);

	public void deleteTicket(Ticket ticket);
}
