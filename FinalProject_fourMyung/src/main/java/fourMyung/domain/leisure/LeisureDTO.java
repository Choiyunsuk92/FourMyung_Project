package fourMyung.domain.leisure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeisureDTO {
	Integer leisureNum;
	String leisureName;
	String leisureAge;
	String leisureTime;
	Integer leisurePrice;
}
