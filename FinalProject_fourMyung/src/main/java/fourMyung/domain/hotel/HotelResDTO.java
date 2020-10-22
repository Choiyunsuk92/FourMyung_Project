package fourMyung.domain.hotel;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class HotelResDTO {
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	Date checkInDt;
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	Date checkOutDt;
	String check_adult;
	String check_child;
	String price;
	String roomNm;
	String roomOfNum;
	String userNm;
	String userPh;
	String addReq;
	String roomDivCd;
	String payType;
	String userId;
	String roomNum;
}
