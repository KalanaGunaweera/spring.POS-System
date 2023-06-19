package spring.POSSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.POSSystem.dto.CustomerDTO;
import spring.POSSystem.dto.ItemDTO;
import spring.POSSystem.dto.request.RequestSaveItemDTO;
import spring.POSSystem.service.CustomerService;
import spring.POSSystem.service.ItemService;
import spring.POSSystem.util.StandardResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(path="/save")
    public String saveItem(@RequestBody RequestSaveItemDTO itemDTO){
       String saveItem= itemService.addItem(itemDTO);
       return "savedItem";
    }
    @GetMapping(path = "get-by-name/{name}")
    public List<ItemDTO> allItembyName(@PathVariable("name") String itemName){
        List<ItemDTO> itemDTOList = itemService.getItemByName(itemName);
        return itemDTOList;
    }
//
//    public List<ItemDTO> getallItems(){
//        List<ItemDTO> itemDTOS = itemService.getAllItems();
//        return itemDTOS;
//    }
    @GetMapping(path = "get-all-items")
    public ResponseEntity<StandardResponse> getAllItems(){
        List<ItemDTO> itemDTOS = itemService.getAllItems();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",itemDTOS),
                HttpStatus.OK);
    }








}
