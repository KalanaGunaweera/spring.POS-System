package spring.POSSystem.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.POSSystem.entity.enums.MeasuringUnitType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private int itemId;
    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQuantity;
    private double supplierPrice;
    private double sellingPrice;
    private boolean itemActiveState;
}
