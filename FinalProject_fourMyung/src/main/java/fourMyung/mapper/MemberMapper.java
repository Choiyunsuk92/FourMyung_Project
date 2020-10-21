package fourMyung.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fourMyung.domain.hotel.HotelResInfoDTO;
import fourMyung.domain.member.MemberDTO;
import fourMyung.domain.member.PwChangeDTO;

@Component
@Repository(value="fourMyung.mapper.MemberMapper")
public interface MemberMapper {
	public Integer insertMember(MemberDTO dto)throws Exception;
	public Integer joinOkUpdate(MemberDTO dto)throws Exception;
	public List<MemberDTO> selectByMember(MemberDTO dto)throws Exception;
	public Integer memberUpdate(MemberDTO member)throws Exception;
	public Integer pwChange(PwChangeDTO dto)throws Exception;
	public Integer myInfoDel(String userId)throws Exception;
	public List<HotelResInfoDTO> myPageHotel(String userId) throws Exception;
}
