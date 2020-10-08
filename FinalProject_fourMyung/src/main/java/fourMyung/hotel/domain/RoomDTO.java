package fourMyung.hotel.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
@Data
public class RoomDTO {
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
	String roomLayer; // 층수
	String roomTo; // 기준인원
	String roomSize; // 크기
	String bedInfo; // 침대구성
	String offerSvc; // 제공서비스
	String roomImg; // 객실이미지
}
