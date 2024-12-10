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
 * @since 2024-12-10
 */
@Getter
@Setter
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    private String medicineList;

    private String status;

    private String type;

    private String diseaseInfo;


}
