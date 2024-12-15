package com.ccl.userboot.medicinestore.service;

import com.ccl.userboot.medicinestore.dao.entity.Doctors;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ccl.userboot.medicinestore.dto.resp.DoctorListRespDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ccl
 * @since 2024-12-12
 */
public interface IDoctorsService extends IService<Doctors> {
    List<DoctorListRespDTO> getDoctorList(Integer size, Integer offset);

}
