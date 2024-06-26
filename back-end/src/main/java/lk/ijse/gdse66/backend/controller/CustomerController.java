package lk.ijse.gdse66.backend.controller;


import lk.ijse.gdse66.backend.dto.CustomerDTO;
import lk.ijse.gdse66.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController() {
        System.out.println("customer working !");
    }

    @PostMapping("/save")
    public CustomerDTO save(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
//        customerDTO.setCode(customerService.generateNextId());
        return customerService.saveCustomer(customerDTO);
    }

    @PatchMapping ("/update")
    public CustomerDTO update(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
        return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/{id}")

    public String delete(@PathVariable(value = "id")String id){

        System.out.println(id);
        return String.valueOf(customerService.deleteCustomer(id));

    }
    @GetMapping("/getAllCustomers")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/nextId")
    public String nextId(){
        return customerService.generateNextId();
    }

    @GetMapping("/search/{name}")
     public List<CustomerDTO> searchCustomer(@PathVariable(value = "name")String name){
        return customerService.searchCustomer(name);
    }

    @GetMapping("/searchName/{id}")
    public CustomerDTO searchCustomerName(@PathVariable(value = "id")String id){
        return customerService.searchCustomerById(id);
    }


    @GetMapping("/sendWishes")
    public List<String> sendWishes(){
        return customerService.sendWishes();
     }
}
