package com.oss.inventoryservice.controller;

import com.oss.inventoryservice.dto.InventoryResponse;
import com.oss.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;


    @GetMapping()
    public List<InventoryResponse> inStock(@RequestParam List<String> skuNumbers){
        return inventoryService.inStock(skuNumbers);
    }

}
