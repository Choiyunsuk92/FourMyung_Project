package fourMyung.hotel.domain;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class RoomDTO {
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	LocalDateTime chek_In_Date;
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	LocalDateTime chek_Out_Date;
	String check_adult;
	String check_child;
}
