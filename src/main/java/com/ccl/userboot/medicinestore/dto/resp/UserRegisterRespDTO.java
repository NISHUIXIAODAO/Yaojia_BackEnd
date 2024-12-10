package com.ccl.userboot.medicinestore.dto.resp;

import lombok.Data;

@Data
public class UserRegisterRespDTO {
    private String token;
    private String userName;
    private String userEmail;
}
