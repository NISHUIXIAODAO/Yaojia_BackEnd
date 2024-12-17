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
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine> implements MedicineService {

    List<String> counts = Arrays.asList("10", "23","67","88");

    List<String> department = Arrays.asList("协和医院","人民医院","小丑医院");

    @Override
    public List<MedicineListRespDTO> getMedicineList(Integer size, Integer offset) {
        Page<Medicine> page = new Page<>(offset, size);
        IPage<Medicine> medicinePage = baseMapper.selectPage(
                page, new QueryWrapper<>()
        );
        List<Medicine> medicines = medicinePage.getRecords();
        return convertMedicineListToDtoList(medicines);
    }

    public List<MedicineListRespDTO> convertMedicineListToDtoList(List<Medicine> medicines) {
        List<MedicineListRespDTO> dtoList = new ArrayList<>();
        Random random = new Random();
        for (Medicine medicine : medicines) {
            MedicineListRespDTO dto = new MedicineListRespDTO();
            dto.setCount(counts.get(random.nextInt(4)));
            dto.setDepartment(department.get(random.nextInt(3)));
            BeanUtil.copyProperties(medicine, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
