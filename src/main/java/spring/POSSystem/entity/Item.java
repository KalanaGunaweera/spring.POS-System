package spring.POSSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.POSSystem.entity.enums.MeasuringUnitType;

@Entity
@Table(name = "Item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @Column(name = "Item_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "Item_Name", length = 100,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "Measure_Type", length = 25,nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "Balance_Quantity", length = 50,nullable = false)
    private double balanceQuantity;

    @Column(name = "Supplier_Price", length = 50,nullable = false)
    private double supplierPrice;

    @Column(name = "Selling Price", length = 50,nullable = false)
    private double sellingPrice;

    @Column(name = "Item_Status", columnDefinition = "TINYINT default 1")
    private boolean itemActiveState;

}
