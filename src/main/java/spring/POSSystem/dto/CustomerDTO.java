package spring.POSSystem.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private int customerId;

    private String customerName;

    private String customerAddrress;

    private String customerNIC;

    private double customerSalary;

    private boolean customerActiveState;

}
