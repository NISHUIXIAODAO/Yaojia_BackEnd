package com.ccl.userboot.medicinestore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ccl.userboot.medicinestore.dao.mapper")
@SpringBootApplication
public class MedicineStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicineStoreApplication.class, args);
    }

}
