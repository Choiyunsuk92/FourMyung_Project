package fourMyung.domain.member;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MemberDTO implements Serializable {
	String memDivCd;
	String userId;
	String userPass; 
	String userNm;
	Timestamp userBirth;
	String userEmail;
	String userPh;
	String userAddr;
	String userGender;
	Timestamp joinDt;
	String joinOk;
}
