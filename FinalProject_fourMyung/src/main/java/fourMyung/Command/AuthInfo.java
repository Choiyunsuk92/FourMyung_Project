package fourMyung.Command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthInfo {
	private String userId;
	private String userPass;
	private String userEmail;
	private String userNm;
}
