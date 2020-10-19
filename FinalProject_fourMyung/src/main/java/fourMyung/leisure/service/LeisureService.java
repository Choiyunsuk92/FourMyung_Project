package fourMyung.leisure.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.LeisureCommand;
import fourMyung.Command.ReservCommand;
import fourMyung.domain.leisure.LeisureDTO;
import fourMyung.mapper.LeisureMapper;

@Service
@Component
public class LeisureService {
	@Autowired
	LeisureMapper leisureMapper;
	
	public Integer insertLeisure(LeisureCommand leisureCommand, Model model) {
		Integer result = null;
		LeisureDTO dto = new LeisureDTO();
		dto.setLeisureName(leisureCommand.getLeisureName());
		dto.setLeisureAge(leisureCommand.getLeisureAge());
		dto.setLeisureTime(leisureCommand.getLeisureTime());
		dto.setLeisurePrice(leisureCommand.getLeisurePrice());
		result = leisureMapper.insertLeisure(dto);
		return result;
	}

	public void selectByLeisure(Model model) {
		LeisureDTO leisuredto = new LeisureDTO();
		List<LeisureDTO> list = leisureMapper.selectByLeisure(leisuredto);
		System.out.println(list.size());
		model.addAttribute("list", list);
	}

	public void deleteLeisure(Integer leisureNum) {
		leisureMapper.leisureDel(leisureNum);
	}

	public void leisureCheck(Model model, HttpSession session)throws Exception {
		int count = leisureMapper.getLeisureCount();
		LeisureDTO dto = new LeisureDTO();
		List<LeisureDTO> list = leisureMapper.selectByLeisure(dto);
		System.out.println(list.size());
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		try {
			Integer totalPrice = 0;
			ReservCommand reservCommand = (ReservCommand)session.getAttribute("reservCommand");
			int i = 0;
	
				for( String  leisure : reservCommand.getListLeisure() ) {
					for(LeisureDTO leisureDTO : list) {
						if(leisure.equals(leisureDTO.getLeisureNum().toString())) {
							totalPrice += leisureDTO.getLeisurePrice() * Integer.parseInt(reservCommand.getListCnt().get(i));
							break;
						}
					}
					i++;
				}
				model.addAttribute("totalPrice", totalPrice);
				session.setAttribute("totalPrice", totalPrice);
		}catch(Exception e) {}

	}
}