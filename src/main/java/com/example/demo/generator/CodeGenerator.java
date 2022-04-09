package com.example.demo.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Mybatis生成器
 *
 * @author yinchd
 * @date 2019 /3/26
 */
public class CodeGenerator {

    /**
     * 当前项目的路径
     */
    static final String PROJECT_PATH = System.getProperty("user.dir");
    /**
     * java文件路径
     */
    static final String CODE_HOME = "D:\\workspace\\demo\\src\\main\\java";

    /**
     * 代码生成器入口.
     */
    public static void main(String[] args) {
        // 待生成的表名
        String tableName = "sfx_web_user_role";
        // 生成的时候要去掉的表前缀，如果不需要去除什么前缀，则这里为空就行
        String trimTablePrefix = "sfx_web_";
        // 生成文件的父包路径
        String codeGeneratePath = "com.example.demo";
        System.out.println("开始生成如下表：" + tableName + " 到 " + codeGeneratePath + " 目录中...");
        // 后面三个boolean值分别代表是否生成Controller、Service、Dao和实体，有时我们改了表结构，这里可以方便控制生成哪些，不生成哪些
        generate(tableName, trimTablePrefix, codeGeneratePath, true, true, true);
        System.out.println("生成成功...");
    }

    /**
     * 代码生成入口
     * @param tableName 表名
     * @param trimTablePrefix 要去除的表前缀 eg：表名：t_user, 如果不去除`t_`前缀的话，则生成的类名为TUser，如果去掉，则生成的类名为User
     * @param basePkg 生成文件的父包路径
     * @param controller 是否生成controller
     * @param service 是否生成service
     * @param mapper 是否生成mapper
     */
    private static void generate(String tableName, String trimTablePrefix, String basePkg,
                                 boolean controller, boolean service, boolean mapper) {
        AutoGenerator generator = new AutoGenerator();
        // 全局配置
        generator.setGlobalConfig(getGlobalConfig());
        // 数据源
        generator.setDataSource(getDataSourceConfig());
        // 生成策略
        generator.setStrategy(getStrategyConfig(tableName, trimTablePrefix));
        // 生成模板
        generator.setTemplate(getTemplateConfig(controller, service, mapper));
        // 生成目标信息
        generator.setPackageInfo(getPackageConfig(basePkg));

        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        new FileOutConfig() {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return PROJECT_PATH + "/src/main/resources/mybatis/" + tableInfo.getEntityName() + StringPool.DOT_XML;
            }
        };
        injectionConfig.setFileOutConfigList(focList);
        generator.setCfg(injectionConfig);

        // 执行生成
        generator.execute();
    }

    private static PackageConfig getPackageConfig(String basePkg) {
        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        // 父包路径
        packageConfig.setParent(basePkg);
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("mapper");
        packageConfig.setEntity("model");
        packageConfig.setXml("mapper.xml");
        return packageConfig;
    }

    private static GlobalConfig getGlobalConfig() {
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        // 生成文件输出根目录
        globalConfig.setOutputDir(CODE_HOME);
        // 生成完成后不弹出文件框
        globalConfig.setOpen(false);
        // 文件覆盖
        globalConfig.setFileOverride(true);
        // 不需要ActiveRecord特性的请改为false
        globalConfig.setActiveRecord(false);
        // XML 二级缓存
        globalConfig.setEnableCache(false);
        // XML ResultMap
        globalConfig.setBaseResultMap(true);
        // XML columList
        globalConfig.setBaseColumnList(false);
        // 作者
        globalConfig.setAuthor("冯邵兵");
        globalConfig.setSwagger2(false);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        globalConfig.setControllerName("%sController");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setEntityName("%sModel");
        return globalConfig;
    }

    private static TemplateConfig getTemplateConfig(boolean controller, boolean service, boolean mapper) {
        // 解决Mapper.java上没有@Mapper注解的问题
        TemplateConfig templateConfig = new TemplateConfig();
        if (!controller) {
            templateConfig.setController("");
        }
        if (!service) {
            templateConfig.setService("").setServiceImpl("");
        }
        templateConfig.setMapper("/generator/mapper.java.vm");
        if (!mapper) {
            templateConfig.setMapper("").setXml("");
        }
        return templateConfig;
    }

    private static StrategyConfig getStrategyConfig(String tableName, String trimTablePrefix) {
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();

        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        // 需要生成的表
        strategy.setInclude(tableName);
        strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
        strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);

        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntityColumnConstant(true);
        strategy.setEntityBuilderModel(true);
        strategy.setEntityTableFieldAnnotationEnable(true);

        // 去除表前缀
        if (trimTablePrefix != null && !"".equals(trimTablePrefix)) {
            strategy.setTablePrefix(trimTablePrefix);
        }
        // 去除字段前缀
        // strategy.setFieldPrefix("");
        return strategy;
    }

    private static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        // 设置数据库类型（如果是数据库，DbType要切换成对应的类型）
        dataSourceConfig.setDbType(DbType.MYSQL);
        // 如果是其它库，DriverName要替换成对应的类型
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        // 数据库连接地址，如果是其它类型数据库，这里填上对应的url
        dataSourceConfig.setUrl("jdbc:mysql://192.168.167.87:3306/starfx?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8");
        // 用户名
        dataSourceConfig.setUsername("starfx");
        // 密码
        dataSourceConfig.setPassword("starfx");
        return dataSourceConfig;
    }

}
