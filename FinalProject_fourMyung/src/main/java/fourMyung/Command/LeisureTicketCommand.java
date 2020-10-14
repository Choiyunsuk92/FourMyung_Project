package fourMyung.Command;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class LeisureTicketCommand {
	String ticketNum;
	Integer leisureNum;
	Integer ticketQty;
	Integer totalPrice;
	String phNum;
}
