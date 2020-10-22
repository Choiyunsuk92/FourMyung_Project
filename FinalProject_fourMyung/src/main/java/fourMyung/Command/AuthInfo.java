package fourMyung.Command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthInfo {
	private String userId;
	private String memDivCd;
	private String userPass;
	private String userNm;
	private String userEmail;
	private String userGender;
	private String userBirth;
	private String userPh;
	private String joinOk;
	
	
}
