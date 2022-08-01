package com.zbx.rilsy.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Collections;

/**
 * @author zbx
 * @date 2022/5/6
 * @describe Mybatis-plus代码自动生成
 **/
public class MyBatisGenerator {
    private final static String url = "jdbc:mysql://42.193.218.79:13658/hcums?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
    private final static String username = "root";
    private final static String password = "Zbx.33578";
    private final static DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder(url, username, password);

    private final static String outputDir = "C:\\Users\\Administrator\\Desktop\\nb\\rilsy\\src\\main\\java";
    private final static String packName = "com.zbx.rilsy.system";
    private final static String mapperDir = "C:\\Users\\Administrator\\Desktop\\nb\\rilsy\\src\\main\\resources\\mapper\\system";
    private final static String[] table = {"system_captcha"};

    public static void main(String[] args) {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .globalConfig(builder -> {
                    builder.author("zbx") // 设置作者
                            .outputDir(outputDir); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(packName) // 设置父包名
                            .moduleName(null) // 防止controller双斜杠
                            .mapper("dao")
                            .entity("entity.po")
                            .controller("api")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, mapperDir)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder()
                            .formatFileName("%sPo")
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Column("create_by", FieldFill.INSERT))
                            .addTableFills(new Column("update_time", FieldFill.UPDATE))
                            .addTableFills(new Column("update_by", FieldFill.UPDATE))
                            .controllerBuilder()
                            .enableRestStyle()
                            .mapperBuilder()
                            . formatMapperFileName("%sDao")
                            .enableMapperAnnotation();
                    builder.addTablePrefix("system_");
                    builder.addInclude(table); // 设置需要生成的表名
                })
                .execute();
    }
}