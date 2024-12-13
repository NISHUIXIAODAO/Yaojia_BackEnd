package com.ccl.userboot.medicinestore.dto.resp;

import lombok.Data;

@Data
public class UserLoginRespDTO {
    private String token;
    private String userName;
    private String userEmail;
    private String loginStatus;

}
