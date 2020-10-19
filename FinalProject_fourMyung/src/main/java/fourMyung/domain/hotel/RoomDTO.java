package fourMyung.domain.hotel;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
@Data
public class RoomDTO {
	String roomSeq;
	String roomNum;
	String roomNm;
	String roomClass;
	String price;
	String roomResYn;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	Date chek_In_Date;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	Date chek_Out_Date;
	String check_adult;
	String check_child;
	String roomLayer; // 층수
	String roomTo; // 기준인원
	String roomSize; // 크기
	String bedInfo; // 침대구성
	String offerSvc; // 제공서비스
	String originalFileName;
	String storeFileName;
	String fileSize;
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	Date sysCretDt;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	Date sysMdfDt;
	String empNm;
	String empNum;
	String etc;
	String roomImg;
}
