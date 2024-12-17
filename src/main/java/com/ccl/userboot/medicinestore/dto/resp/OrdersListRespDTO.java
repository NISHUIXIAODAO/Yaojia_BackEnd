package com.ccl.userboot.medicinestore.dto.resp;

import lombok.Data;

@Data
public class OrdersListRespDTO {
    private Integer orderId;

    private String medicineList;

    private String status;

    private String userName;

    private String type;

    private String diseaseInfo;
}
