package fourMyung.member.service;

import java.sql.Timestamp;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import fourMyung.Command.MemberCommand;
import fourMyung.controller.MailAction;
import fourMyung.controller.SmsSend;
import fourMyung.domain.member.MemberDTO;
import fourMyung.mapper.MemberMapper;

@Service
@Component
@Transactional
public class MemberJoinService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MailAction mailAction;
	
	public Integer insertMember(MemberCommand memberCommand, Model model)throws Exception {
		if(!memberCommand.UserPwEqualToUserPwCon()) {
			model.addAttribute("valid_userPwCon", "새암호가 일치하지않습니다.");
			return null;
		}
		Integer result = null;
		MemberDTO dto = new MemberDTO();
		Timestamp userBirth = Timestamp.valueOf(memberCommand.getUserBirth());
		dto.setMemDivCd(memberCommand.getMemDivCd());
		dto.setUserId(memberCommand.getUserId());
		dto.setUserPass(passwordEncoder.encode(memberCommand.getUserPass()));
		dto.setUserNm(memberCommand.getUserNm());
		dto.setUserBirth(userBirth);
		dto.setUserGender(memberCommand.getUserGender());
		dto.setUserEmail(memberCommand.getUserEmail());
		dto.setUserAddr(memberCommand.getUserAddr());
		dto.setUserPh(memberCommand.getUserPh());
		result = memberMapper.insertMember(dto);
		System.out.println(result);
		if(result == null) {
			System.out.println("메롱");
			model.addAttribute("NoUseId", "사용중인 아이디 입니다. ");
		}else {
			SmsSend ss = new SmsSend();
			try {
				mailAction.sendMail(dto.getUserEmail(), dto.getUserId());
				ss.smsSend(dto.getUserPh(), dto.getUserNm()+"님 회원가입을 축하합니다.");
			} catch (MessagingException e) {
				ss.smsSend(dto.getUserPh(), dto.getUserNm()+"님 회원가입을 축하합니다. "+ "그러나 1588-0000 으로 문의 바랍니다.");
				e.printStackTrace();
			}
		}
		return result;
	}

	public Integer joinOkUpdate(String joinOk, String reciver, String userId)throws Exception {
		MemberDTO dto = new MemberDTO();
		dto.setUserId(userId);
		dto.setUserEmail(reciver);
		dto.setJoinOk(joinOk);
		
		return memberMapper.joinOkUpdate(dto);
	}

}
