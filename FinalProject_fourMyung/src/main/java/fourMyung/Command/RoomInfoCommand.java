package fourMyung.Command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class RoomInfoCommand {
	String roomSeq;
	String roomNum; // 객실 호수
	String roomNm;
	String roomClass;
	String price; 
	String roomResYn; // 예약가능여부
	String roomLayer; // 층수
	String roomTo; // 기준인원
	String roomSize; // 크기
	String bedInfo; // 침대구성
	String offerSvc; // 제공서비스
	MultipartFile [] roomImg; // 룸이미지
}
