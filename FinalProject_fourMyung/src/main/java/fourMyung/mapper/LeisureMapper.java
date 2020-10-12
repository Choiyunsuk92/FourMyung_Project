package fourMyung.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fourMyung.domain.leisure.LeisureDTO;

@Component
@Repository(value = "fourMyung.mapper.LeisureMapper")
public interface LeisureMapper {
	public Integer insertLeisure(LeisureDTO dto);
	public List<LeisureDTO> selectByLeisure(LeisureDTO leisuredto);
	public Integer leisureDel(Integer leisureNum);
	public Integer getLeisureCount();
}
