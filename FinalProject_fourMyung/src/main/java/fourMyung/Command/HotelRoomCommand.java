package fourMyung.Command;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class HotelRoomCommand {
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	LocalDate chek_In_Date;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	LocalDate chek_Out_Date;
	String check_adult;
	String check_child;
}
