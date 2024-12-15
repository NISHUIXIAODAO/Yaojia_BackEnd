package com.ccl.userboot.medicinestore.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author ccl
 * @since 2024-12-12
 */
@Getter
@Setter
public class Doctors implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "doctor_id", type = IdType.AUTO)
    private Integer doctorId;

    private String doctorName;

    private String doctorWorkload;


}
