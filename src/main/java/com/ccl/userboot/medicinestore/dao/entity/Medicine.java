package com.ccl.userboot.medicinestore.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("Medicine")
public class Medicine {
    private Integer medicineId;
    private String medicineName;
    private String medicineFunction;
    private BigDecimal medicinePrice;
}
