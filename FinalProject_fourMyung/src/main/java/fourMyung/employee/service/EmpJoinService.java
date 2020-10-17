package fourMyung.employee.service;

import java.sql.Timestamp;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import fourMyung.Command.EmpCommand;
import fourMyung.controller.MailAction;
import fourMyung.controller.SmsSend;
import fourMyung.domain.member.EmployeeDTO;
import fourMyung.mapper.EmpMapper;

@Service
@Component
@Transactional
public class EmpJoinService {
	@Autowired
	EmpMapper empMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MailAction mailAction;
	public Integer insertEmployee(EmpCommand empCommand, Model model)throws Exception {
		if(!empCommand.UserPwEqualToUserPwCon()) {
			model.addAttribute("valid_empPwCon", "새암호가 일치하지않습니다.");
			return null;
		}
		Integer result = null;
		EmployeeDTO dto = new EmployeeDTO();
		Timestamp empBirth = Timestamp.valueOf(empCommand.getEmpBirth());
		dto.setMemDivCd(empCommand.getMemDivCd());
		dto.setEmpId(empCommand.getEmpId());
		dto.setEmpPass(passwordEncoder.encode(empCommand.getEmpPass()));
		dto.setEmpNm(empCommand.getEmpNm());
		dto.setEmpBirth(empBirth);
		dto.setEmpGender(empCommand.getEmpGender());
		dto.setEmpEmail(empCommand.getEmpEmail());
		dto.setEmpAddr(empCommand.getEmpAddr());
		dto.setEmpPh(empCommand.getEmpPh());
		result = empMapper.insertEmp(dto);
		if(result != null) {
			SmsSend ss = new SmsSend();
			try {
				mailAction.sendMail1(dto.getEmpEmail(), dto.getEmpId());
				ss.smsSend(dto.getEmpPh(), dto.getEmpNm()+"님 회원가입을 축하합니다.");
			} catch (MessagingException e) {
				ss.smsSend(dto.getEmpPh(), dto.getEmpNm()+"님 회원가입을 축하합니다. "+ "그러나 1588-0000 으로 문의 바랍니다.");
				e.printStackTrace();
			}
		}else {
			model.addAttribute("duplicate_empId", "사용중인 아이디 입니다.");
		}
		return result;
	}
	public Integer joinOkUpdate(String joinOk, String reciver, String empId)throws Exception {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpId(empId);
		dto.setEmpEmail(reciver);
		dto.setJoinOk(joinOk);
		
		return empMapper.joinOkUpdate(dto);
	}

}
