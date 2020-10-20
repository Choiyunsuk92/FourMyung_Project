package fourMyung.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fourMyung.domain.pay.PayDTO;

@Component
@Repository(value="fourMyung.mapper.PayMapper")
public interface PayMapper {

	public Integer payInfoInsert(PayDTO dto) throws Exception;
}
