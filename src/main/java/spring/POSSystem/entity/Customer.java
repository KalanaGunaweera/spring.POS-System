package spring.POSSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name = "Customer_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    @Column(name = "Customer_Name", length = 100,nullable = false)
    private String customerName;
    @Column(name = "Customer_Address", length = 250)
    private String customerAddrress;
    @Column(name = "Customer_NIC")
    private String customerNIC;
    @Column(name = "Customer_Salary")
    private double customerSalary;
    @Column(name = "Customer_Status", columnDefinition = "TINYINT default 1")
    private boolean customerActiveState;

}
