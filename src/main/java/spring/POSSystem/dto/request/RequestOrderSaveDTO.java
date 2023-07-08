package spring.POSSystem.dto.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.POSSystem.entity.Customer;
import spring.POSSystem.entity.OrderDetails;

import java.util.Date;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDTO {
    private int customers;
    private Date date;
    private Double total;
    private List<RequestOrderDetailsSaveDTO> orderDetails;

}
