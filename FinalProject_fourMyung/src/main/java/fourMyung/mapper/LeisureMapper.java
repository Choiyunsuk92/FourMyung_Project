package fourMyung.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fourMyung.domain.leisure.LeisureDTO;
import fourMyung.domain.leisure.LeisureTicketDTO;
import fourMyung.domain.leisure.LeisureTicketDetailDTO;
import fourMyung.domain.leisure.LeisureUserInfoDTO;

@Component
@Repository(value = "fourMyung.mapper.LeisureMapper")
public interface LeisureMapper {
	public Integer insertLeisure(LeisureDTO dto);
	public List<LeisureDTO> selectByLeisure(LeisureDTO leisuredto);
	public Integer leisureDel(Integer leisureNum);
	public Integer getLeisureCount();
	public String selectTicketNum();
	public Integer insertTicket(LeisureTicketDTO dto);				//xml에서 반환값이 없으므로 void
	public void insertLeisureUser(LeisureUserInfoDTO user);
	public Integer insertTicketDetail(LeisureTicketDetailDTO dto);
}
