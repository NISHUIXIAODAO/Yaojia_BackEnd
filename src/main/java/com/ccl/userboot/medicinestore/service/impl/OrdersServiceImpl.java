package com.ccl.userboot.medicinestore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccl.userboot.medicinestore.common.convention.exception.ClientException;
import com.ccl.userboot.medicinestore.common.convention.result.Result;
import com.ccl.userboot.medicinestore.common.convention.result.Results;
import com.ccl.userboot.medicinestore.dao.entity.Orders;
import com.ccl.userboot.medicinestore.dao.mapper.OrdersMapper;
import com.ccl.userboot.medicinestore.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ccl
 * @since 2024-12-10
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Result<Map<String, Object>> getAllOrders(int size, int pageNum) {
        Page<Orders> page = new Page<>(pageNum, size, true);
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();

        IPage<Orders> blogPage = ordersMapper.selectPage(page, queryWrapper);

        List<Orders> blogs = blogPage.getRecords();
        long totalcount = blogPage.getTotal();

        // 添加日志
        System.out.println("Total records found: " + totalcount);
        System.out.println("Current page: " + page.getCurrent());
        System.out.println("Total pages: " + page.getPages());

        Map<String, Object> result = new HashMap<>();
        result.put("orders", blogs);
        result.put("totalcount", totalcount);

        return Results.success(result);
    }
}
