package spring.POSSystem.service.customerServiceIMPL;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.POSSystem.dto.ItemDTO;
import spring.POSSystem.dto.request.RequestSaveItemDTO;
import spring.POSSystem.entity.Item;
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
        List<ItemDTO> itemDTOList = itemMapper.entityListToDTOList(items);
        return itemDTOList;
    }
}
