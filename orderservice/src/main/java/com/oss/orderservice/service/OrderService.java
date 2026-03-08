package com.oss.orderservice.service;

import com.oss.orderservice.dto.InventoryResponse;
import com.oss.orderservice.dto.OrderLineItemsDto;
import com.oss.orderservice.dto.OrderRequest;
import com.oss.orderservice.entity.Order;
import com.oss.orderservice.entity.OrderLineItems;
import com.oss.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public void placeOrder( OrderRequest orderRequest){
        if (orderRequest.getOrderLineItemsDto() == null ||
                orderRequest.getOrderLineItemsDto().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemList=orderRequest.getOrderLineItemsDto().stream()
                .map(orderLineItemsDto -> mapToDto(orderLineItemsDto))
                .toList();

        order.setOrderLineItems(orderLineItemList);

        List<String> skuNumbers = order.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

//        call inventory serve and place order if product is available
        InventoryResponse[] inventoryResponseArray= webClient.get()
                .uri("http://localhost:8083/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuNumbers", skuNumbers).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean result=Arrays.stream(inventoryResponseArray)
                .allMatch(inventoryResponse -> inventoryResponse.isInStock());

        if(result){
            orderRepository.save(order);
        }else{
            throw new IllegalArgumentException("Item Not in Stock, Plz try again");
        }

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }


    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
