package spring.POSSystem.service;

import org.springframework.stereotype.Service;
import spring.POSSystem.dto.ItemDTO;
import spring.POSSystem.dto.request.RequestSaveItemDTO;

import java.util.List;

@Service
public interface ItemService {
    String addItem(RequestSaveItemDTO itemDTO);

    List<ItemDTO> getItemByName(String itemName);

    List<ItemDTO> getAllItems();
}
