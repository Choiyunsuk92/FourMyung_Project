package fourMyung.Command;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ReservCommand {
	List<String> listLeisure;
	List<String> listCnt;
	Date useDate;	
}
