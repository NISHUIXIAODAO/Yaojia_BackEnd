package com.ccl.userboot.medicinestore.dto.resp;

import com.ccl.userboot.medicinestore.dao.entity.enums.UserStatus;
import lombok.Data;

import java.util.Date;

@Data
public class UserListRespDTO {
    private Integer userId;

    private String userName;

    private String userEmail;

    private UserStatus userStatus;

    private Date createdAt;
}
