package fourMyung.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fourMyung.Command.EmpCommand;
import fourMyung.employee.service.EmpJoinService;


@Controller
@RequestMapping("emp")
public class EmployeeController {
	@Autowired
	EmpJoinService empJoinService;
	
	@ModelAttribute
	EmpCommand setEmpCommand() {
		return new EmpCommand();
	}
	
	@RequestMapping(value="regist", method = RequestMethod.GET)
	public String regist() {
		return "thymeleaf/employee/employeeForm";
	}

	@RequestMapping(value="regist", method = RequestMethod.POST)
	public String regist1(Model model) {
		return "thymeleaf/employee/employeeForm";
	}

	@RequestMapping(value="registOk", method = RequestMethod.POST)
	public String registOk(@Validated EmpCommand empCommand, BindingResult result, Model model)throws Exception {
		if(result.hasErrors()) {
			return "thymeleaf/employee/employeeForm";
		}
		Integer i = empJoinService.insertEmployee(empCommand,model) ;
		if(i == null) return "thymeleaf/employee/employeeForm";
		return "redirect:/";
	}
	@RequestMapping(value="memberMail", method = RequestMethod.GET)
	public String memberMail(@RequestParam(value="num")String joinOk, 
							 @RequestParam(value="reciver")String reciver, 
							 @RequestParam(value="empId")String empId)throws Exception {
		Integer i = empJoinService.joinOkUpdate(joinOk, reciver, empId);
		System.out.println(i);
		if(i > 0) {
			return "thymeleaf/member/success";
		}else {
			return "thymeleaf/member/fail";
		}
	}
}
