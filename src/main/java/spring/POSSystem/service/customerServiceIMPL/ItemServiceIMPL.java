package spring.POSSystem.service.customerServiceIMPL;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spring.POSSystem.dto.ItemDTO;
import spring.POSSystem.dto.paginated.PaginatedResponseItemDto;
import spring.POSSystem.dto.request.RequestSaveItemDTO;
import spring.POSSystem.entity.Item;
import spring.POSSystem.exception.NotFoundException;
import spring.POSSystem.repository.ItemRepository;
import spring.POSSystem.service.ItemService;
import spring.POSSystem.util.mappers.ItemMapper;


import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

//    @Override
//    public String addItem(RequestSaveItemDTO requestSaveItemDTO) {
//        Item item = itemMapper.requestDtoToEntity(requestSaveItemDTO);
//        item.setItemActiveState(false);
//        if(!itemRepository.existsById(item.getItemId())){
//            itemRepository.save(item);
//            return "saved";
//        }else {
//            return "Item id not found.. ";
//        }
//
//    }

    @Override
    public String addItem(RequestSaveItemDTO requestSaveItemDTO) {
       // Item item = modelMapper.map(requestSaveItemDTO,Item.class);
        Item item = itemMapper.requestDtoToEntity(requestSaveItemDTO);
        item.setItemActiveState(false);
        if(!itemRepository.existsById(item.getItemId())){
            itemRepository.save(item);
            return "saved";
        }else {
            return "Item id not found.. ";
        }

    }

    @Override
    public List<ItemDTO> getItemByName(String itemName) {
        List<Item> items = itemRepository.findAllByItemNameIs(itemName);
        List<ItemDTO> itemDTOList = itemMapper.entityListToDTOList(items);
        return itemDTOList;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();
        if(items.size()>0){
            List<ItemDTO> itemDTOList = itemMapper.entityListToDTOList(items);
            return itemDTOList;
        }
        throw new NotFoundException("data not found");

    }

    @Override
    public PaginatedResponseItemDto getAllItemsActive(int page, int size, int activeState) {
        Page<Item> items = itemRepository.findAllByActiveStateEquals(activeState,PageRequest.of(page,size));
//        int count = itemRepository.countAllByActiveStateEquals(activeState);
//        List<ItemDTO> itemDTOS = itemMapper.pageTOList(items);
//        PaginatedResponseItemDto paginatedResponseItemDto = new PaginatedResponseItemDto(itemDTOS,count);
//        return paginatedResponseItemDto;
        return new PaginatedResponseItemDto(itemMapper.pageTOList(items),itemRepository.countAllByActiveStateEquals(activeState));


    }

//    @Override
//    public List<ItemDTO> getAllItemsActive() {
//        List<Item> items = itemRepository.findAll();
//        if(items.size()>0){
//            List<ItemDTO> itemDTOList = itemMapper.entityListToDTOList(items);
//            return itemDTOList;
//        }
//        throw new NotFoundException("data not found");
//
//    }
}
