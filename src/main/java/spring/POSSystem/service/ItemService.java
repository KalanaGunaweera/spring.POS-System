package spring.POSSystem.service;

import org.springframework.stereotype.Service;
import spring.POSSystem.dto.ItemDTO;
import spring.POSSystem.dto.paginated.PaginatedResponseItemDto;
import spring.POSSystem.dto.request.RequestSaveItemDTO;

import java.util.List;

@Service
public interface ItemService {
    String addItem(RequestSaveItemDTO itemDTO);

    List<ItemDTO> getItemByName(String itemName);

    List<ItemDTO> getAllItems();

    PaginatedResponseItemDto getAllItemsActive(int page, int size, int activeState);

//    List<ItemDTO> getAllItemsActive();
}
