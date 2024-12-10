package com.ccl.userboot.medicinestore;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import java.util.Collections;

public class CodeGeneratorForGDBC {

    public static void main(String[] args) {
        FastAutoGenerator.create(new DataSourceConfig.Builder(
                        "jdbc:mysql://localhost:3306/YAOJIA?useUnicode=true&characterEncoding=UTF-8&rewriteBatchedStatements=true&allowMultiQueries=true&serverTimezone=Asia/Shanghai",
                        "root",
                        "MY040323."))
                .globalConfig(builder -> {
                    builder.author("ccl") // 设置作者
                            .outputDir(System.getProperty("user.dir") + "/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.ccl.userboot.medicinestore") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.other, System.getProperty("user.dir") + "/src/main/resources/mapper/xml")); // 设置Mapper XML生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("Orders") // 设置需要生成的表名
                            .entityBuilder().naming(NamingStrategy.underline_to_camel).enableLombok() // 生成的实体类使用Lombok
                            .controllerBuilder().enableRestStyle() // 生成 @RestController 控制器
                            .mapperBuilder().enableBaseResultMap().enableBaseColumnList(); // 启用 BaseResultMap 和 BaseColumnList
                })
                .templateEngine(new VelocityTemplateEngine()) // 使用Velocity模板引擎
                .execute();
    }
    }
