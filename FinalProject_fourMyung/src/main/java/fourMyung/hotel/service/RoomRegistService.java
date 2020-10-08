package fourMyung.hotel.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import fourMyung.Command.RoomInfoCommand;
import fourMyung.domain.hotel.RoomDTO;
import fourMyung.mapper.HotelMapper;

@Component
@Service
public class RoomRegistService {
	
	@Autowired
	HotelMapper hotelMapper;
	public String roomInsert(RoomInfoCommand roomInfoCommand, Model model, HttpServletRequest request) throws Exception{
		// TODO Auto-generated method stub
		RoomDTO roomDTO = new RoomDTO();
		
		// 룸이미지 입력
		String originalTotal ="";
		String storeTotal = "";
		String fileSizeTotal = "";
		String location ="";
		String path = "/static/upload/hotel";
		String filePath = request.getServletContext().getRealPath(path);
		
		System.out.println("realPath : " + filePath);
		for(MultipartFile mf : roomInfoCommand.getRoomImg()) {
			String original = mf.getOriginalFilename(); // 전송된 파일명
			String originalFileExtension = original.substring(original.lastIndexOf("."));
			String store =  UUID.randomUUID().toString().replace("-", "") + originalFileExtension; // 임의의 파일명 + 확장자
			String fileSize = Long.toString(mf.getSize());
			System.out.println("origianl 파일명: "+original);
			originalTotal += original + "`";
			storeTotal += store + "`";
			fileSizeTotal += fileSize + "`";
			
			// 파일을 저장하기 위해 파일 객체 생성
			File file = new File(filePath + "/" + store);
			try {
				mf.transferTo(file);
			}catch (Exception e) {
				// TODO: handle exception
				location = "thymeleaf/hotel/room/room_Write";
				e.printStackTrace();
			}
		}
		roomDTO.setOriginalFileName(originalTotal);
		roomDTO.setStoreFileName(storeTotal);
		roomDTO.setFileSize(fileSizeTotal);
		
		int i = hotelMapper.roomInsert(roomDTO);
		System.out.println(i+"개의 객실 정보가 등록되었습니다.");
		location = "redirect:/hotel/room_List";
		return location;
	}

}
