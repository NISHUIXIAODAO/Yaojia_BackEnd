package com.ccl.userboot.medicinestore.controller;


import com.ccl.userboot.medicinestore.common.convention.result.Result;
import com.ccl.userboot.medicinestore.service.IOrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ccl
 * @since 2024-12-10
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrdersController {
    private final IOrdersService ordersService;

    @GetMapping("/getOrderList")
    public Result<Map<String, Object>> getAllOrders(@RequestParam int size,@RequestParam int offset){
        return ordersService.getAllOrders(size, offset);
    }

}

