package com.ccl.userboot.medicinestore.controller;


import com.ccl.userboot.medicinestore.common.convention.result.Result;
import com.ccl.userboot.medicinestore.common.convention.result.Results;
import com.ccl.userboot.medicinestore.dto.resp.DockerListRespDTO;
import com.ccl.userboot.medicinestore.service.IDockersService;
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
@RequestMapping("/dockers")
public class DockersController {
    @Autowired
    private IDockersService dockersService;

    @GetMapping("/getDockerList")
    public Result getDockerList(@RequestParam Integer size, @RequestParam Integer offset) {
        List<DockerListRespDTO> results = dockersService.getDockerList(size,offset);
        return Results.success(results);
    }

}

