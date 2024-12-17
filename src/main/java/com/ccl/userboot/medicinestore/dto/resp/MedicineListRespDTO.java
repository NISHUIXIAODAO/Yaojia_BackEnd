package com.ccl.userboot.medicinestore.dto.resp;

import lombok.Data;

@Data
public class MedicineListRespDTO {
    private Integer medicineId;
    private String medicineName;
    private String count;
    private String department;
    private String medicineFunction;
    private String medicinePrice;
}
