package fourMyung.leisure.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.AuthInfo;
import fourMyung.Command.ReservCommand;
import fourMyung.Command.ReservCommand2;
import fourMyung.domain.member.MemberDTO;

@Service
@Component
public class LeisureReservService {
	AuthInfo authInfo;
	
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
		  
		  System.out.println("useDate : "+useDate);
		  
	}

	public void memberCheck(HttpSession session, ReservCommand2 reservCommand2,  Model model) {
		session.setAttribute("userEmail", reservCommand2.getUserEmail());
		session.setAttribute("userPh", reservCommand2.getUserPh());
		System.out.println("new_userEmail : "+reservCommand2.getUserEmail());
		System.out.println("new_userph : "+reservCommand2.getUserPh());
	}
	 
}
