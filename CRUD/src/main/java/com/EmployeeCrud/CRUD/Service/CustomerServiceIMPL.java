package com.EmployeeCrud.CRUD.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.EmployeeCrud.CRUD.CustomerRepo.CustomerRepo;
import com.EmployeeCrud.CRUD.DTO.CustomerDTO;
import com.EmployeeCrud.CRUD.DTO.CustomerSaveDTO;
import com.EmployeeCrud.CRUD.DTO.CustomerUpdateDTO;
import com.EmployeeCrud.CRUD.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String addCustomer(CustomerSaveDTO customerSaveDTO) {
        Customer customer = new Customer(
                customerSaveDTO.getCustomername(),
                customerSaveDTO.getCustomeraddress(),
                customerSaveDTO.getMobile()
        );
//                (
//                        customerSaveDTO.getCustomername(),
//                        customerSaveDTO.getCustomeraddress(),
//                        customerSaveDTO.getMobile()
//                );

        customerRepo.save(customer);
        return customer.getCustomername();
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> getCustomer = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer a : getCustomer) {
            CustomerDTO customerDTO = new CustomerDTO(
                    a.getCustomerid(),
                    a.getCustomername(),
                    a.getCustomeraddress(),
                    a.getMobile()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String updateCustomers(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerid())) {
            Customer customer = customerRepo.getById(customerUpdateDTO.getCustomerid());
            customer.setCustomername(customerUpdateDTO.getCustomername());
            customer.setCustomeraddress(customerUpdateDTO.getCustomeraddress());
            customer.setMobile(customerUpdateDTO.getMobile());
            customerRepo.save(customer);

        } else {
            System.out.println("Customer ID doesn't Exist! ");

        }

        return null;
    }

    @Override
    public boolean deleteCustomer(int id) {
        if(customerRepo.existsById(id))
        {
            customerRepo.deleteById(id);
        }
        else
        {
            System.out.println("Customer ID not found");
        }
        return true;
    }
}
