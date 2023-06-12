package spring.POSSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.POSSystem.dto.CustomerDTO;
import spring.POSSystem.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(path="/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.addCustomer(customerDTO);
        return "Saved customer";
    }
    @PutMapping("/update")
    public String updateCustomer(CustomerDTO customerDTO){
        String updated= customerService.updateCustomer(customerDTO);
        return updated;
    }
    @GetMapping("/get-by-id/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") int customerId){
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }

    @GetMapping(path = "/get-all-customers")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(path= "/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String delete = customerService.deleteCustomer(customerId);
        return delete;
    }
}
