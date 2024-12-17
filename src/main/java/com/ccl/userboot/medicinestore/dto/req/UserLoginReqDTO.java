package com.ccl.userboot.medicinestore.dto.req;

import lombok.Data;

@Data
public class UserLoginReqDTO {
    private String userEmail;
    private String userPassword;
}
