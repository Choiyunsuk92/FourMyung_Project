package fourMyung.Command;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class HotelRoomCommand {
	String roomNum;
	String roomNm;
	String roomClass;
	String price;
	String roomResYn;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	LocalDate chek_In_Date;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	LocalDate chek_Out_Date;
	String check_adult;
	String check_child;
}
