package fourMyung.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fourMyung.domain.hotel.HotelResDTO;
import fourMyung.domain.hotel.HotelResInfoDTO;
import fourMyung.domain.hotel.RoomDTO;


@Component
@Repository(value="fourMyung.mapper.HotelMapper")
public interface HotelMapper {
	
	public List<RoomDTO> roomSearch(RoomDTO dto) throws Exception;
	public List<RoomDTO> roomListSelect() throws Exception;
	public Integer roomInsert(RoomDTO dto) throws Exception;
	public Integer hotelResInsert(HotelResDTO dto) throws Exception;
	public void roomResYnUpdate(HotelResDTO dto) throws Exception;
	public HotelResInfoDTO resInfoSelect(HotelResDTO dto) throws Exception;
}
