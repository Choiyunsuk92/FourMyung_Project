package fourMyung.Command;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ReservCommand2 {
	String userEmail;
	String userPh;
}
