package com.ccl.userboot.medicinestore.service;

import com.ccl.userboot.medicinestore.common.convention.result.Result;
import com.ccl.userboot.medicinestore.common.convention.result.Results;
import com.ccl.userboot.medicinestore.dao.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ccl
 * @since 2024-12-10
 */
public interface IOrdersService extends IService<Orders> {
     Result<Map<String, Object>> getAllOrders(int size, int page);
}
