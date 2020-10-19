package fourMyung.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.domain.member.MemberDTO;
import fourMyung.mapper.MemberMapper;

@Service
@Component
public class MemberInfoService {
	@Autowired
	MemberMapper memberMapper;

	public MemberDTO myInfo(String userId, Model model)throws Exception {
		MemberDTO dto = new MemberDTO();
		dto.setUserId(userId);
		dto = memberMapper.selectByMember(dto).get(0);
		model.addAttribute("member", dto);
		return dto;
	}
}
