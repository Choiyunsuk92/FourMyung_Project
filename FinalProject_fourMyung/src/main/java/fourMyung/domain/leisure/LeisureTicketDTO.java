package fourMyung.domain.leisure;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeisureTicketDTO {
	String ticketNum;
	Integer totalPrice;
	String phNum;
	Date useDate;
	Date resDate;
	String payType;
}
