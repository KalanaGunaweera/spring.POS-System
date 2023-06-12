package spring.POSSystem.service.customerServiceIMPL;
import org.modelmapper.TypeToken;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.POSSystem.dto.CustomerDTO;
import spring.POSSystem.entity.Customer;
import spring.POSSystem.repository.CustomerRepository;
import spring.POSSystem.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddrress(),
                customerDTO.getCustomerNIC(),
                customerDTO.getCustomerSalary(),
                customerDTO.isCustomerActiveState()
        );

        if (!customerRepository.existsById(customer.getCustomerId())){
            customerRepository.save(customer);
        }else {
            System.out.println("Customer id is exist in database");
        }

    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {
        if(customerRepository.existsById(customerDTO.getCustomerId())){
            Customer customer = customerRepository.getById(customerDTO.getCustomerId());

            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomerAddrress(customerDTO.getCustomerAddrress());
            customer.setCustomerSalary(customerDTO.getCustomerSalary());

            customerRepository.save(customer);
            return "Updated...";
        }else {
            System.out.println("Customer id not found...");
            return "Customer id not found...";

        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        Customer customer = customerRepository.getReferenceById(customerId);
        CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class);
        return customerDTO;

//        Customer customer = customerRepository.getById(customerId);
//        if(customer!=null){
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddrress(),
//                    customer.getCustomerNIC(),
//                    customer.getCustomerSalary(),
//                    customer.isCustomerActiveState()
//            );
//            return customerDTO;
//        }else {
//            return null;
//        }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
//        List<Customer> getCustomers = customerRepository.findAll();
//        List<CustomerDTO> customerDTOlist = new ArrayList<>();
//        for (Customer customer:getCustomers){
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddrress(),
//                    customer.getCustomerNIC(),
//                    customer.getCustomerSalary(),
//                    customer.isCustomerActiveState()
//            );
//            customerDTOlist.add(customerDTO);

        List<Customer> getCustomers = customerRepository.findAll();
        List<CustomerDTO> customerDTOlist = new ArrayList<>();

        if(getCustomers!=null){
            customerDTOlist=modelMapper.map(getCustomers,new TypeToken<List<CustomerDTO>>(){}.getType());
        }
        return customerDTOlist;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepository.existsById(customerId)){
            customerRepository.deleteById(customerId);
            return "deleted";
        }else{
            return "No customer found that ID";
        }
    }
}
