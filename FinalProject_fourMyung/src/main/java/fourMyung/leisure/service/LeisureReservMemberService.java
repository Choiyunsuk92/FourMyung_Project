package fourMyung.leisure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.domain.leisure.ReservListDTO;
import fourMyung.mapper.LeisureMapper;

@Service
@Component
public class LeisureReservMemberService {
	@Autowired
	LeisureMapper leisureMapper;
	
	public void reservList(Model model) {
//		LeisureTicketDetailDTO dto = new LeisureTicketDetailDTO();
//		System.out.println(dto.getTicketNum());
		List<ReservListDTO> list = leisureMapper.selectByTicket();
		model.addAttribute("list", list);
	}

}
