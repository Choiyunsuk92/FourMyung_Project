package fourMyung.Command;

import lombok.Data;

@Data
public class PayCommand {
	String checkInDt;
	String checkOutDt;
	String check_adult;
	String check_child;
	String price;
	String prodNm;
	String roomOfNum;
	String userNm;
	String userPh;
	String addReq;
	String roomDivCd;
	String payType;
}
