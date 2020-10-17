package fourMyung.domain.member;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	String empId;
	String memDivCd;
	String empNm;
	String empPass;
	Timestamp empBirth;
	String empGender;
	String empAddr;
	String empEmail;
	String empPh;
	String department;
	Timestamp hireDate;
	String empImage;
	String joinOk;
	
//	CREATE TABLE M_EMPLOYEE(
//			EMP_ID VARCHAR(20) NOT NULL PRIMARY KEY,
//			MEM_DIV_CD VARCHAR(2) NOT NULL,
//			EMP_NM VARCHAR(50) NOT NULL,
//			EMP_PASS VARCHAR(20) NOT NULL,
//			EMP_BIRTH TIMESTAMP NOT NULL,
//			EMP_GENDER VARCHAR(1) NOT NULL,
//			EMP_ADDR VARCHAR(255) NOT NULL,
//			EMP_EMAIL VARCHAR(40) NOT NULL,
//			EMP_PH VARCHAR(30) NOT NULL,
//			DEPARTMENT VARCHAR(255),
//			HIRE_DATE TIMESTAMP NOT NULL,
//			EMP_IMAGE VARCHAR(255)
//		);
}
