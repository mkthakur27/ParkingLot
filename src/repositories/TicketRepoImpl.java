package repositories;

import java.util.HashMap;
import java.util.Map;

import exception.InvalidTicketIdException;
import model.Ticket;

public class TicketRepoImpl implements IticketRepo {

	private Map<String,Ticket> ticketStorage = new HashMap<>();
	static TicketRepoImpl ticketRepo = new TicketRepoImpl();
	private TicketRepoImpl() {}
	public static TicketRepoImpl getInstance()
	{
		return ticketRepo;
	}
	@Override
	public void save(Ticket ticket) {
		ticketStorage.put(ticket.getId(), ticket);

	}
	@Override
	public Ticket find(String ticketId) throws InvalidTicketIdException {
		if (ticketStorage.containsKey(ticketId))
		{
			return ticketStorage.get(ticketId);
		}
		else
		{
			throw new InvalidTicketIdException("Not a valid Ticket");
		}
	}
	@Override
	public void delete(Ticket ticket) {
		// TODO Auto-generated method stub
		ticketStorage.remove(ticket);
	}

}
