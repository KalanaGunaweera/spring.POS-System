package spring.POSSystem.dto.paginated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.POSSystem.dto.ItemDTO;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaginatedResponseItemDto {
    private List<ItemDTO> list;
    private long dataCount;
}
