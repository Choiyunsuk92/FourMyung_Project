package fourMyung.Command;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class HotelRoomCommand {
	String roomNum;
	String roomNm;
	String roomClass;
	String price;
	String roomResYn;
	String chek_In_Date;
	String chek_Out_Date;
	String check_adult;
	String check_child;
	String roomOfNum;
}
