package com.ccl.userboot.medicinestore.dto.req;

import lombok.Data;

@Data
public class UserRegisterReqDTO {
    private String userName;
    private String userPassword;
    private String userEmail;
//    private String code;神经，哪有验证码
}
