package com.ccl.userboot.medicinestore.controller;

import com.ccl.userboot.medicinestore.common.convention.result.Result;
import com.ccl.userboot.medicinestore.common.convention.result.Results;
import com.ccl.userboot.medicinestore.dto.resp.MedicineListRespDTO;
import com.ccl.userboot.medicinestore.dto.resp.UserListRespDTO;
import com.ccl.userboot.medicinestore.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medicine")
public class MedicineController {
    private final MedicineService medicineService;

    @GetMapping("/getMedicineList")
    public Result getUserList(@RequestParam Integer size, @RequestParam Integer offset){
        List<MedicineListRespDTO> results = medicineService.getMedicineList(size, offset);
        return Results.success(results);
    }
}
