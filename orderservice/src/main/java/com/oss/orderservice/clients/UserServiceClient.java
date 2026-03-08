package com.oss.orderservice.clients;

import com.oss.orderservice.dto.UserResponseDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface UserServiceClient {
    @GetExchange("api/user/getUser/{id}")
    UserResponseDto getUserDetails(@PathVariable String id);

}
