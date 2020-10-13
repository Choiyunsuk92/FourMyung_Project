package fourMyung.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fourMyung.domain.member.MemberDTO;

@Component
@Repository(value="fourMyung.mapper.MemberMapper")
public interface MemberMapper {
	public Integer insertMember(MemberDTO dto)throws Exception;
	public Integer joinOkUpdate(MemberDTO dto)throws Exception;
	public List<MemberDTO> selectByMember(MemberDTO dto)throws Exception;
}
