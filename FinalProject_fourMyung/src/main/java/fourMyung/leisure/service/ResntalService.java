package fourMyung.leisure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fourMyung.Command.RentalCommand;
import fourMyung.domain.leisure.RentalDTO;
import fourMyung.mapper.RentalMapper;

@Service
@Component
public class ResntalService {
	@Autowired
	RentalMapper rentalMapper;
	
	public Integer insertGoods(RentalCommand rentalCommand, Model model) {
		Integer result = null;
		RentalDTO dto = new RentalDTO();
		dto.setGoodsName(rentalCommand.getGoodsName());
		dto.setGoodsPrice(rentalCommand.getGoodsPrice());
		dto.setGoodsAge(rentalCommand.getGoodsAge());
		dto.setGoodsAmount(rentalCommand.getGoodsAmount());
		result = rentalMapper.insertRental(dto);
		return result;
		
	}

	public void selectByRental(Model model)throws Exception {
		RentalDTO dto = new RentalDTO();
		List<RentalDTO> list = rentalMapper.selectByRental(dto);
		model.addAttribute("list", list);
	}

	public void deleteGoods(String goodsNum) {
		rentalMapper.goodsDel(goodsNum);
	}

}
