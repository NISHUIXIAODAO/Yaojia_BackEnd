package com.ccl.userboot.medicinestore.controller;

import com.ccl.userboot.medicinestore.common.convention.result.Result;
import com.ccl.userboot.medicinestore.common.convention.result.Results;
import com.ccl.userboot.medicinestore.dao.entity.User;
import com.ccl.userboot.medicinestore.dto.req.UserListReqDTO;
import com.ccl.userboot.medicinestore.dto.req.UserLoginReqDTO;

import com.ccl.userboot.medicinestore.dto.req.UserRegisterReqDTO;
import com.ccl.userboot.medicinestore.dto.resp.UserListRespDTO;
import com.ccl.userboot.medicinestore.dto.resp.UserLoginRespDTO;
import com.ccl.userboot.medicinestore.dto.resp.UserRegisterRespDTO;
import com.ccl.userboot.medicinestore.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public Result<UserLoginRespDTO> login(HttpServletResponse response
            , @RequestBody UserLoginReqDTO userLoginReqDTO) {
        UserLoginRespDTO resp = userService.login(response,userLoginReqDTO);
        return Results.success(resp);
    }

    @PostMapping("/register")
    public Result<UserRegisterRespDTO> userRegister(HttpServletResponse response, @RequestBody UserRegisterReqDTO requestParam){
        val result = userService.register(response, requestParam);
        return Results.success(result);
    }

    @GetMapping("/code")
    public Result<String> getCode(){
        return null;
    }

    @GetMapping("/getUserList")
    public Result getUserList(@RequestParam Integer size, @RequestParam Integer offset){
        List<UserListRespDTO> results = userService.getUserList(size, offset);
        return Results.success(results);
    }
}
