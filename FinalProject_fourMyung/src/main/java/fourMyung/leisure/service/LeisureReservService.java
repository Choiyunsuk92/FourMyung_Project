package fourMyung.leisure.service;

import java.sql.Timestamp;
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

import fourMyung.Command.AuthInfo;
import fourMyung.Command.PayCommand;
import fourMyung.Command.ReservCommand;
import fourMyung.Command.ReservCommand2;
import fourMyung.domain.leisure.LeisureTicketDTO;
import fourMyung.domain.leisure.LeisureTicketDetailDTO;
import fourMyung.domain.leisure.LeisureUserInfoDTO;
import fourMyung.mapper.LeisureMapper;
import fourMyung.mapper.PayMapper;

@Service
@Component
public class LeisureReservService {
	AuthInfo authInfo;
	@Autowired
	LeisureMapper leisureMapper;
	@Autowired
	PayMapper payMapper;
	
	public void ticketCheck(Model model, HttpSession session, HttpServletRequest request)throws Exception { 
		List<String> listLeisure = new ArrayList<String>();
		List<String> listCnt = new ArrayList<String>();
		String useDate1 = null;
		
		Enumeration enums = request.getParameterNames();      // 11행
		  while (enums.hasMoreElements()) {                     
		    String name = (String)enums.nextElement();
		    System.out.println(name);
		    if (name.startsWith("leisureNum")) {   // "option"으로 시작하는 문자열인지 확인
		      String value = request.getParameter(name);
//		      int i = Integer.parseInt(name.replace("leisureNum",""));
		      listLeisure.add(value);
		    }
		   if (name.startsWith("count")) {   // "option"으로 시작하는 문자열인지 확인
		      String value = request.getParameter(name);
//		      int i = Integer.parseInt(name.replace("count",""));
		      listCnt.add(value);
		    }
		   if(name.equals("useDate")) {
			   useDate1 = request.getParameter(name);
		   }
		  }
		  
		  ReservCommand reservCommand = new ReservCommand();
		  SimpleDateFormat ud = new SimpleDateFormat("yyyy-MM-dd");
		  Date useDate = ud.parse(useDate1);
		  
		  reservCommand.setListLeisure(listLeisure);
		  reservCommand.setListCnt(listCnt);
		  reservCommand.setUseDate(useDate);
		  session.setAttribute("reservCommand", reservCommand);
	}

	public void memberCheck(HttpSession session, ReservCommand2 reservCommand2,  Model model) {
		session.setAttribute("userEmail", reservCommand2.getUserEmail());
		session.setAttribute("userPh", reservCommand2.getUserPh());
	}

	public void insertTicketNum( HttpServletRequest request, HttpSession session)throws Exception {
		String num = leisureMapper.selectTicketNum();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		PayCommand payCommand = (PayCommand) session.getAttribute("resInfo");
		
		LeisureTicketDTO dto = new LeisureTicketDTO();
		dto.setTicketNum(num);
		dto.setTotalPrice((Integer)session.getAttribute("totalPrice"));
		dto.setPhNum((String)session.getAttribute("userPh"));
		
		ReservCommand reservCommand = (ReservCommand)session.getAttribute("reservCommand");
		dto.setUseDate(reservCommand.getUseDate());
		System.out.println(reservCommand.getUseDate());
		dto.setPayType(payCommand.getPayType());
		leisureMapper.insertTicket(dto);
		
		LeisureUserInfoDTO user = new LeisureUserInfoDTO();
		user.setTicketNum(num);
		user.setUserId(((AuthInfo)session.getAttribute("authInfo")).getUserId());
		leisureMapper.insertLeisureUser(user);
		
		System.out.println(reservCommand.getListCnt().get(0));
		int i = 0;
		for(String leisureNum : reservCommand.getListLeisure()) {
			LeisureTicketDetailDTO detail = new LeisureTicketDetailDTO();
			String qty =  reservCommand.getListCnt().get(i);
			detail.setTicketNum(num);
			detail.setLeisureNum(leisureNum);
			detail.setTicketQty(Integer.parseInt(qty));
			if(Integer.parseInt(qty) != 0) {
				leisureMapper.insertTicketDetail(detail);
			}
			i++;
		}
		
		int j = payMapper.leisurePayInsert(userId);
		
		session.removeAttribute("reservCommand");
		session.removeAttribute("userEmail");
		session.removeAttribute("userPh");
		session.removeAttribute("totalPrice");
	}
}
