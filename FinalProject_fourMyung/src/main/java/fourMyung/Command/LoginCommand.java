package fourMyung.Command;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginCommand {
	String memDivCd;
	@NotEmpty(message="아이디를 입력하세요")
	String userId;
	@NotEmpty(message="비밀번호를 입력하세요")
	String userPass;
}
