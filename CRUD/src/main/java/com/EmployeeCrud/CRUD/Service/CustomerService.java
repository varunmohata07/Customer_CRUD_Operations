package com.EmployeeCrud.CRUD.Service;

import com.EmployeeCrud.CRUD.DTO.CustomerDTO;
import com.EmployeeCrud.CRUD.DTO.CustomerSaveDTO;
import com.EmployeeCrud.CRUD.DTO.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerSaveDTO customerSaveDTO);

    List<CustomerDTO> getAllCustomer();

    String updateCustomers(CustomerUpdateDTO customerUpdateDTO);

    boolean deleteCustomer(int id);
}
