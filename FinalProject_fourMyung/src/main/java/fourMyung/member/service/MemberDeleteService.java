package fourMyung.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fourMyung.mapper.MemberMapper;

@Service
@Component
public class MemberDeleteService {
	@Autowired
	MemberMapper memberMapper;
	
	public void memberDelete(String userId)throws Exception {
		memberMapper.myInfoDel(userId);
		
	}
	
}
