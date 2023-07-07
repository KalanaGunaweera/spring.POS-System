package spring.POSSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderDetails {
    @Id
    @Column(name="order_details_id",length=45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsId;

    @Column(name = "Item_Name", length = 100,nullable = false)
    private String itemName;

    @Column(name = "Quantity", length = 50,nullable = false)
    private double quantity;

    @Column(name = "amount",nullable = false)
    private Double amount;
}
