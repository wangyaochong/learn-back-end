package com.example.shiro;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class MybatisCodeGeneratorDataSourceTest {
    static String driverName = "com.mysql.cj.jdbc.Driver";
    static String ip = "127.0.0.1";
    static String userName = "wangyaochong";
    static String password = "qwerqwer";
    static final String dbName = "shiro";
    static String port = "3306";
    static String basePackage = "com.example.shiro.generated." + dbName;
    static String mapperPath = "/shiro/src/main/resources/mapper";
    static String projectBase = "/shiro";
    static String serviceImplName = "%sRepoImpl";
    static String serviceName = "%sRepo";
    static String[] generateTableNames = {"role","perm","user_role","role_perm"};

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir")+projectBase;
        System.out.println("projectPath="+projectPath);
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setAuthor("mybatis-plus generated");
        globalConfig.setOpen(false);
        globalConfig.setSwagger2(true);
        globalConfig.setIdType(IdType.AUTO);

        globalConfig.setFileOverride(true);
        globalConfig.setServiceImplName(serviceImplName);
        globalConfig.setServiceName(serviceName);
//        globalConfig.setBaseColumnList(true);
//        globalConfig.setBaseResultMap(true);
        mpg.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://" + ip + ":" + port + "/" + dbName + "?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT");
        // dsc.setSchemaName("public");
        dsc.setDriverName(driverName);
        dsc.setUsername(userName);
//        dsc.setPassword("qwer@Qwer");
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(basePackage);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper" + "/" + dbName + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(generateTableNames);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.getTemplate().setController(null);//不生成controller
//        mpg.getTemplate().setService(null);//不生成service
//        mpg.getTemplate().setServiceImpl(null);//不生成serviceImpl
//        mpg.getTemplate().setMapper(null);//不生成mapper
//        mpg.getTemplate().setXml(null);//不生成xml
        mpg.execute();
    }

}
