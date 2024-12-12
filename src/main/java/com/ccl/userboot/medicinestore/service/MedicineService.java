package com.ccl.userboot.medicinestore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ccl.userboot.medicinestore.dao.entity.Medicine;
import com.ccl.userboot.medicinestore.dto.resp.MedicineListRespDTO;

import java.util.List;

public interface MedicineService extends IService<Medicine> {
    List<MedicineListRespDTO> getMedicineList(Integer size, Integer offset);
}
