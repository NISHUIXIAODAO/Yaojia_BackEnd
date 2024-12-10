package com.ccl.userboot.medicinestore.controller;

import com.ccl.userboot.medicinestore.common.convention.result.Result;
import com.ccl.userboot.medicinestore.common.convention.result.Results;
import com.ccl.userboot.medicinestore.dao.entity.User;
import com.ccl.userboot.medicinestore.dto.req.UserListReqDTO;
import com.ccl.userboot.medicinestore.dto.req.UserLoginReqDTO;
import com.ccl.userboot.medicinestore.dto.req.UserRegisterReqDTO;
import com.ccl.userboot.medicinestore.dto.resp.UserListRespDTO;
import com.ccl.userboot.medicinestore.dto.resp.UserLoginRespDTO;
import com.ccl.userboot.medicinestore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public Result<UserLoginRespDTO> userLogin(@RequestBody UserLoginReqDTO requestParam) {
        return null;
    }

    @PostMapping("/register")
    public void userRegister(@RequestBody UserRegisterReqDTO requestParam){

    }

    @GetMapping("/code")
    public Result<String> getCode(){
        return null;
    }

    @GetMapping("/getUserList/{size}/{offset}")
    public Result<List<UserListRespDTO>> getUserList(@PathVariable Integer size, @PathVariable Integer offset){
        List<UserListRespDTO> results = userService.getUserList(size, offset);
        return Results.success(results);
    }
}
