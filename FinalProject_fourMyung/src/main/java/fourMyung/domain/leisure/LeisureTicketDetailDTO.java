package fourMyung.domain.leisure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeisureTicketDetailDTO {
	String ticketNum;
	String leisureNum;
	Integer ticketQty;
}
