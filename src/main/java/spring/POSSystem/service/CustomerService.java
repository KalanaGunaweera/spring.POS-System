package spring.POSSystem.service;

import org.springframework.stereotype.Service;
import spring.POSSystem.dto.CustomerDTO;

import java.util.List;

@Service
public interface CustomerService {
    void addCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);
}
