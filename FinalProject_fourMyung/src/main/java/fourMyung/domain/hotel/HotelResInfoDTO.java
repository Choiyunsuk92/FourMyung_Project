package fourMyung.domain.hotel;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class HotelResInfoDTO {
	String RES_NUM;
	String PAY_NUM;
	String MEM_NUM;
	String ROOM_NUM;
	String SRVC_NUM;
	String ROOM_NM;
	String USER_ID;
	String USER_NM;
	String USER_PH;
	Date RES_CHK_IN_DT;
	String RES_CHK_OUT_DT;
	String USE_ADULT;
	String USE_CHILD;
	String ROOM_DIV_CD;
	Date SYS_CRET_DT;
	String SYS_MDF_DT;
	String ADD_REQ;
	String PAY_TYPE;
	Integer PRICE;
	String ROOM_OF_NUM;
	String PAY_TYPE_HANGLE;
	String STTUS;
}
