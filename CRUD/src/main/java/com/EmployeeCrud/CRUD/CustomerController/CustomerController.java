package com.EmployeeCrud.CRUD.CustomerController;
import com.EmployeeCrud.CRUD.DTO.CustomerDTO;
import com.EmployeeCrud.CRUD.DTO.CustomerSaveDTO;
import com.EmployeeCrud.CRUD.DTO.CustomerUpdateDTO;
import com.EmployeeCrud.CRUD.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO){
        String id = customerService.addCustomer(customerSaveDTO);
        return id;
    }

    @GetMapping(path = "/getAllCustomer")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO>allCustomers = customerService.getAllCustomer();
        return allCustomers;
    }

    @PostMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO)
    {
        String id = customerService.updateCustomers(customerUpdateDTO);
        return id;
    }

    @DeleteMapping(path = "/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id)
    {
        boolean deletecustomer = customerService.deleteCustomer(id);
        return "deleted";
    }




}
