package com.ccl.userboot.medicinestore.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccl.userboot.medicinestore.dao.entity.Medicine;
import com.ccl.userboot.medicinestore.dao.mapper.MedicineMapper;
import com.ccl.userboot.medicinestore.dto.resp.MedicineListRespDTO;
import com.ccl.userboot.medicinestore.service.MedicineService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine> implements MedicineService {
    @Override
    public List<MedicineListRespDTO> getUserList(Integer size, Integer offset) {
        Page<Medicine> page = new Page<>(offset, size);
        IPage<Medicine> medicinePage = baseMapper.selectPage(
                page, new QueryWrapper<>()
        );
        List<Medicine> medicines = medicinePage.getRecords();
        return convertUserListToDtoList(medicines);
    }

    public List<MedicineListRespDTO> convertUserListToDtoList(List<Medicine> medicines) {
        List<MedicineListRespDTO> dtoList = new ArrayList<>();
        for (Medicine medicine : medicines) {
            MedicineListRespDTO dto = new MedicineListRespDTO();
            BeanUtil.copyProperties(medicine, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
