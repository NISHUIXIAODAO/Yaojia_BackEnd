package com.ccl.userboot.medicinestore.controller;

import com.ccl.userboot.medicinestore.common.convention.result.Result;
import com.ccl.userboot.medicinestore.common.convention.result.Results;
import com.ccl.userboot.medicinestore.dto.resp.MedicineListRespDTO;
import com.ccl.userboot.medicinestore.dto.resp.UserListRespDTO;
import com.ccl.userboot.medicinestore.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @GetMapping("/getMedicineList/{size}/{offset}")
    public Result<List<MedicineListRespDTO>> getUserList(@PathVariable Integer size, @PathVariable Integer offset){
        List<MedicineListRespDTO> results = medicineService.getUserList(size, offset);
        return Results.success(results);
    }
}
