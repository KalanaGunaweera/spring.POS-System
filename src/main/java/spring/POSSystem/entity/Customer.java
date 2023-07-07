package spring.POSSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    public Customer(int customerId, String customerName, String customerAddrress, String customerNIC, double customerSalary, boolean customerActiveState) {
    }

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

    @OneToMany(mappedBy="customers")
    private Set<Order> orders;


}
