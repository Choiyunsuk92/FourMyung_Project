package fourMyung.domain.leisure;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservListDTO {
	String ticketNum;
	String leisureNum;
	Integer ticketQty;
	Date useDate;
	String userId;
}
