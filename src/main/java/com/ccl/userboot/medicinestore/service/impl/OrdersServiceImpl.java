package com.ccl.userboot.medicinestore.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccl.userboot.medicinestore.common.convention.result.Result;
import com.ccl.userboot.medicinestore.common.convention.result.Results;
import com.ccl.userboot.medicinestore.dao.entity.Medicine;
import com.ccl.userboot.medicinestore.dao.entity.Orders;
import com.ccl.userboot.medicinestore.dao.mapper.OrdersMapper;
import com.ccl.userboot.medicinestore.dto.resp.MedicineListRespDTO;
import com.ccl.userboot.medicinestore.dto.resp.OrdersListRespDTO;
import com.ccl.userboot.medicinestore.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


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

    List<String> username = Arrays.asList("scj", "qq", "yy");;

    @Override
    public Result<Map<String, Object>> getAllOrders(int size, int offset) {
        Page<Orders> page = new Page<>(offset, size, true);
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();

        IPage<Orders> blogPage = ordersMapper.selectPage(page, queryWrapper);

        List<Orders> blogs = blogPage.getRecords();

        List<OrdersListRespDTO> ordersListRespDTOS = convertOrderListToDtoList(blogs);


        long totalcount = blogPage.getTotal();

        // 添加日志
        System.out.println("Total records found: " + totalcount);
        System.out.println("Current page: " + page.getCurrent());
        System.out.println("Total pages: " + page.getPages());

        Map<String, Object> result = new HashMap<>();
        result.put("orders", ordersListRespDTOS);
        result.put("totalcount", totalcount);

        return Results.success(result);
    }

    public List<OrdersListRespDTO> convertOrderListToDtoList(List<Orders> orders) {
        List<OrdersListRespDTO> dtoList = new ArrayList<>();
        Random random = new Random();
        for (Orders order : orders) {
            OrdersListRespDTO dto = new OrdersListRespDTO();
            dto.setUserName(username.get(random.nextInt(3)));
            BeanUtil.copyProperties(order, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
