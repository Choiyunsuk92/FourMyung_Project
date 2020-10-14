package fourMyung.domain.leisure;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeisureTicketDTO {
	String ticketNum;
	Integer leisureNum;
	Timestamp useDate;
	Timestamp resDate;
	Integer ticketQty;
	Integer totalPrice;
	String phNum;
}
