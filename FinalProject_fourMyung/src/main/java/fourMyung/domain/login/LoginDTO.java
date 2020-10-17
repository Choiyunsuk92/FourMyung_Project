package fourMyung.domain.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
	String memDivCd;
	String userId;
	String userPass;
	String userNm;
	String userEmail;
	String userGender;
	String userBirth;
	String userPh;
}
