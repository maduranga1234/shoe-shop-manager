package lk.ijse.gdse66.backend.controller;

import lk.ijse.gdse66.backend.dto.CustomerDTO;
import lk.ijse.gdse66.backend.dto.EmployeeDTO;
import lk.ijse.gdse66.backend.dto.ItemDTO;
import lk.ijse.gdse66.backend.dto.SuplierDTO;
import lk.ijse.gdse66.backend.service.EmployeeService;
import lk.ijse.gdse66.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "*")
public class ItemController {

    public ItemController(){
        System.out.println("Item working");
    }

    @Autowired

    private ItemService itemService;

    @PostMapping("/save")
    public ItemDTO save(@RequestBody ItemDTO itemDTO){
        System.out.println(itemDTO);
//        customerDTO.setCode(customerService.generateNextId());
        return itemService.saveItem(itemDTO);
    }

    @PatchMapping("/update")
    public ItemDTO update(@RequestBody ItemDTO itemDTO){
        System.out.println(itemDTO);
        return itemService.updateItem(itemDTO);
    }

    @DeleteMapping("/{id}")

    public String delete(@PathVariable(value = "id")String id){

        System.out.println(id);
        return String.valueOf(itemService.deleteItem(id));

    }

    @GetMapping("/getAllItem")
    public List<ItemDTO> getAllSupplier(){
        return itemService.getAllItem();
    }

    @GetMapping("/nextId")
    public String nextId(){
        return itemService.generateNextId();
    }

    @GetMapping("/search/{name}")
    public List<ItemDTO> searchItem(@PathVariable(value = "name")String name){
        return itemService.searchItem(name);
    }

    @GetMapping("/searchName/{id}")
    public ItemDTO searchItemName(@PathVariable(value = "id")String id){
        return itemService.searchItemById(id);
    }


    @GetMapping("/searchByName")
    public List<ItemDTO> searchByName(@RequestParam("name")String name){
        return itemService.searchItemByName(name);
    }

    @GetMapping("/getAllItemsByPrice/{minPrice}/{maxPrice}")
    public List<ItemDTO> getAllItemsByPrice(@PathVariable double minPrice,@PathVariable double maxPrice){
        return itemService.getAllItemsByPrice(minPrice, maxPrice);
    }

    @GetMapping("/getAllItemsByCategoryGender")
    public List<ItemDTO> getAllItemsByGender(@RequestParam("gender") String gender){
        System.out.println("gender = "+gender);
        return itemService.getAllItemsByGender(gender);
    }

    @GetMapping("/getAllItemsByCategoryOccasion")
    public List<ItemDTO> getAllItemsByOccasion(@RequestParam("occasion") String occasion){
        System.out.println("occasion = "+occasion);
        return itemService.getAllItemsByGender(occasion);
    }
}
