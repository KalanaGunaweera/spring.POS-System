package spring.POSSystem.util.mappers;
import java.util.List;
import ch.qos.logback.core.model.ComponentModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import spring.POSSystem.dto.ItemDTO;
import spring.POSSystem.dto.request.RequestSaveItemDTO;
import spring.POSSystem.entity.Item;

import java.awt.*;


@Mapper(componentModel="spring")
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);
    Item requestDtoToEntity (RequestSaveItemDTO requestSaveItemDTO);
    List<ItemDTO> entityListToDTOList (List<Item> items);
    List<ItemDTO> pageTOList(Page<Item> items);

    ItemDTO map(Item item);
}
