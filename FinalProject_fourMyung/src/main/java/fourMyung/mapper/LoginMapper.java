package fourMyung.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fourMyung.Command.AuthInfo;
import fourMyung.domain.login.LoginDTO;

@Component
@Repository(value="fourMyung.mapper.LoginMapper")
public interface LoginMapper {
	public AuthInfo login(String userId)throws Exception;
}
