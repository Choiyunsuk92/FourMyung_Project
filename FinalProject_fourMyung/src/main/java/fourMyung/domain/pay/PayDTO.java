package fourMyung.domain.pay;

import lombok.Data;

@Data
public class PayDTO {
	String payNum;
	String payType;
	String payDetail;
	String payPrice;
	String cardNum;
	String payDate;
	String userId;
	String sttusDivCd;
}
