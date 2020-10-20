package fourMyung.domain.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PwChangeDTO {
	String userId;
	String newPw;
}
