package com.ccl.userboot.medicinestore.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccl.userboot.medicinestore.dao.entity.Doctors;
import com.ccl.userboot.medicinestore.dao.mapper.DoctorsMapper;
import com.ccl.userboot.medicinestore.dto.resp.DoctorListRespDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccl.userboot.medicinestore.service.IDoctorsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ccl
 * @since 2024-12-12
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorsMapper, Doctors> implements IDoctorsService {
    @Override
    public List<DoctorListRespDTO> getDoctorList(Integer size, Integer offset) {
        Page<Doctors> page = new Page<>(offset, size);
        IPage<Doctors> doctorsPage = baseMapper.selectPage(
                page, new QueryWrapper<>()
        );
        List<Doctors> doctors = doctorsPage.getRecords();
        return convertDoctorListToDtoList(doctors);
    }

    public List<DoctorListRespDTO> convertDoctorListToDtoList(List<Doctors> doctors) {
        List<DoctorListRespDTO> dtoList = new ArrayList<>();
        for (Doctors doctor : doctors) {
            DoctorListRespDTO dto = new DoctorListRespDTO();
            BeanUtil.copyProperties(doctor, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
