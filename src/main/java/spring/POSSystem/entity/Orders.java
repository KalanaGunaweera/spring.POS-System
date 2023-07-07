package spring.POSSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

import java.util.Date;

@Entity
@Table(name = "orders")

@AllArgsConstructor
@NoArgsConstructor
@Data


public class Orders {

    @Id
    @Column(name="order_id",length=45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @jakarta.persistence.Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customers;

    @Column(name = "order_date",columnDefinition = "DATETIME")
    private Date date;



}
