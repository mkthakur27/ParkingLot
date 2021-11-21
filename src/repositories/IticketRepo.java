package repositories;

import exception.InvalidTicketIdException;
import model.Ticket;

public interface IticketRepo {

	public void save(Ticket ticket);
	public Ticket find(String ticketId) throws InvalidTicketIdException;
	public void delete(Ticket ticket);
}
