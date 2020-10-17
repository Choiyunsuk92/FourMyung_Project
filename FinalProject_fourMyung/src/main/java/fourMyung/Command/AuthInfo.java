package fourMyung.Command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthInfo {
	private String memDivCd;
	private String userId;
	private String userPass;
	private String userEmail;
	private String userNm;
	private String userGender;
	private String userPh;
	private Timestamp userBirth;
	
	
}
