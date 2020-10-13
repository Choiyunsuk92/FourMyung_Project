package fourMyung.domain.leisure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalDTO {
	String goodsNum;
	String goodsName;
	Integer goodsPrice;
	String goodsAge;
	Integer goodsAmount;
	
}
