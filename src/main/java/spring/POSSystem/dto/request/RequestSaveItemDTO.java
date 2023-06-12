package spring.POSSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.POSSystem.entity.enums.MeasuringUnitType;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestSaveItemDTO {
    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQuantity;
    private double supplierPrice;
    private double sellingPrice;
}
