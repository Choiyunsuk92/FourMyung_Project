package fourMyung.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fourMyung.domain.login.LoginDTO;

@Component
@Repository(value="fourMyung.mapper.LoginMapper")
public interface LoginMapper {
	public LoginDTO login(String userId)throws Exception;
}
