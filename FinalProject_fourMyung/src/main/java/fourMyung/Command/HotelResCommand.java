package fourMyung.Command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelResCommand {
	String checkInDt;
	String checkOutDt;
	String check_adult;
	String check_child;
	String price;
	String roomNm;
	String roomOfNum;
	String userNm;
	String userPh;
	String addReq;
	String divCd;
	String roomClass;
}
