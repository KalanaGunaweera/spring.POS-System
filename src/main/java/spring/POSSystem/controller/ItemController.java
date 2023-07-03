package spring.POSSystem.controller;

import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.POSSystem.dto.CustomerDTO;
import spring.POSSystem.dto.ItemDTO;
import spring.POSSystem.dto.paginated.PaginatedResponseItemDto;
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


    //standard method calling...
    @GetMapping(path = "get-all-items")
    public ResponseEntity<StandardResponse> getAllItems(){
        List<ItemDTO> itemDTOS = itemService.getAllItems();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",itemDTOS),
                HttpStatus.OK);
    }

//    @GetMapping(
//            path = "get-all-items-active",
//            params = {"page","size","activeState"}
//    )
//    public ResponseEntity<StandardResponse> getAllItemsActive(
//            @RequestParam (value = "page") int page,
//            @RequestParam (value = "size") @Max(50) int size,
//            @RequestParam (value = "activeState") int activeState
//            ){
////        List<ItemDTO> itemDTOS = itemService.getAllItemsActive();
////        return new ResponseEntity<StandardResponse>(
////                new StandardResponse(200,"Success",itemDTOS),
////                HttpStatus.OK);
//        PaginatedResponseItemDto paginatedResponseItemDto  = itemService.getAllItemsActive(page,size,activeState);
//        return new ResponseEntity<StandardResponse>(
//                new StandardResponse(200,"Success",paginatedResponseItemDto),
//                HttpStatus.OK);
//    }








}
