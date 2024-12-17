package com.ccl.userboot.medicinestore.controller;


import com.ccl.userboot.medicinestore.common.convention.result.Result;
import com.ccl.userboot.medicinestore.common.convention.result.Results;
import com.ccl.userboot.medicinestore.dto.resp.DoctorListRespDTO;
import com.ccl.userboot.medicinestore.service.IDoctorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ccl
 * @since 2024-12-12
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorsController {
    private final IDoctorsService doctorsService;

    @GetMapping("/getDoctorList")
    public Result getDoctorList(@RequestParam Integer size, @RequestParam Integer offset) {
        List<DoctorListRespDTO> results = doctorsService.getDoctorList(size,offset);
        return Results.success(results);
    }
}

