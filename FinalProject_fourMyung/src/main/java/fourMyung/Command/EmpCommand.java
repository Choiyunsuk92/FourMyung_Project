package fourMyung.Command;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpCommand {
	@NotEmpty(message="회원 유형을 선택하세요")
	String memDivCd;
	@Size(min=5, max=12, message="아이디를 입력하세요")
	String empId;
	@NotEmpty(message="비밀번호를 입력하세요")
	String empPass;
	@NotEmpty(message="비밀번호를 한번 더 입력하세요")
	String empPwCon;
	@NotEmpty(message="회원 이름을 입력하세요")
	String empNm;
	@NotNull(message="회원 생년월일을 입력하세요")
	@DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
	LocalDateTime empBirth;
	@NotEmpty(message="이메일을 입력하세요")
	String empEmail;
	@NotEmpty(message="대표전화번호를 입력하세요")
	String empPh;
	@NotNull(message="회원 성별을 선택하세요")
	String empGender;
	@NotEmpty(message="회원 주소를 입력하세요")
	String empAddr;
	
	public boolean UserPwEqualToUserPwCon() {
		if(empPass.equals(empPwCon)) {
			return true;
		}
		return false;
	}
}
