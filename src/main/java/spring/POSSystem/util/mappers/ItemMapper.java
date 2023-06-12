package spring.POSSystem.util.mappers;

import ch.qos.logback.core.model.ComponentModel;
import org.mapstruct.Mapper;
import spring.POSSystem.dto.ItemDTO;
import spring.POSSystem.dto.request.RequestSaveItemDTO;
import spring.POSSystem.entity.Item;

import java.awt.*;
import java.util.List;

@Mapper(componentModel="spring")
public interface ItemMapper {
    Item requestDtoToEntity (RequestSaveItemDTO requestSaveItemDTO);
    List<ItemDTO> entityListToDTOList (List<Item> items);
}
