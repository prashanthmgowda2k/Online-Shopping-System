package com.oss.inventoryservice.service;

import com.oss.inventoryservice.dto.InventoryResponse;
import com.oss.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> inStock(List<String> skuNumber){
        return inventoryRepository.findBySkuNumberIn(skuNumber).stream()
                .map(inventory-> InventoryResponse.builder().
                        skuNumber(inventory.getSkuNumber())
                        .inStock(inventory.getQuantity()>0)
                        .build() ).toList();

    }
}
