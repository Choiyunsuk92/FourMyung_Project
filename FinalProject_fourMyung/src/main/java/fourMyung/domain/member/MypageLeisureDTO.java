package fourMyung.domain.member;

import java.util.Date;

import lombok.Data;

@Data
public class MypageLeisureDTO {
	String TICKET_NUM;
	String PAY_NUM;
	String TOTAL_PRICE;
	Date USE_DATE;
	Date RES_DATE;
	String PAY_TYPE;
	String LEISURE_NAME;
	String LEISURE_AGE;
	String TICKET_QTY;
	String STTUS_DIV_CD;
	String LEISURE_TIME;
}
