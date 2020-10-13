package fourMyung.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fourMyung.domain.leisure.RentalDTO;


@Component
@Repository(value = "fourMyung.mapper.RentalMapper")
public interface RentalMapper {
	public Integer insertRental(RentalDTO dto);
	public List<RentalDTO> selectByRental(RentalDTO dto)throws Exception;
	public Integer goodsDel(String goodsNum);
}
