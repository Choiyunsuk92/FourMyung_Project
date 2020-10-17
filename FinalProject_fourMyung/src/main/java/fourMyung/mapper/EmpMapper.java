package fourMyung.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fourMyung.domain.member.EmployeeDTO;


@Component
@Repository(value="fourMyung.mapper.EmpMapper")
public interface EmpMapper {
	public Integer insertEmp(EmployeeDTO dto)throws Exception;
	public Integer joinOkUpdate(EmployeeDTO dto)throws Exception;
}
