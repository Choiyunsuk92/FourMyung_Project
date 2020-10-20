package fourMyung.domain.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
	String userId;
	String memDivCd;
	String userPass;
	String userNm;
	String userEmail;
	String userGender;
	String userBirth;
	String userPh;
}
