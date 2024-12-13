package com.ccl.userboot.medicinestore.dto.req;

import lombok.Data;

@Data
public class UserRegisterReqDTO {
    private String userName;
    private String userPassage;
    private String userEmail;
//    private String code;神经，哪有验证码
}
