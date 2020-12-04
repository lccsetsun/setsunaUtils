package com.alibaba.lcc.common.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* author: 夕阳
* date: 2020/10/14
* Description:
*/
public class MPGenerator {
    private static final Logger log = LoggerFactory.getLogger(cn.com.citydo.starter.mybatisPlus.generator.MPGenerator.class);

    public MPGenerator() {
    }

    public static void generator(GeneratorCondition condition) {
        if (null == condition) {
            log.error("请传入正确的参数");
        } else {
            final String projectPath;
            if (condition.getIsMultiModule()) {
                if (StringUtils.isBlank(condition.getModelName())) {
                    log.error("请输入模块名");
                    return;
                }

                File file = new File(condition.getModelName());
                projectPath = file.getAbsolutePath();
            } else {
                projectPath = System.getProperty("user.dir");
            }

            AutoGenerator autoGenerator = new AutoGenerator();
            GlobalConfig globalConfig = new GlobalConfig();
            String osName = System.getProperty("os.name");
            if (osName != null && osName.contains("Mac")) {
                globalConfig.setOutputDir(projectPath + "/src/main/java");
            } else {
                globalConfig.setOutputDir(projectPath + "\\src\\main\\java");
            }

            globalConfig.setFileOverride(condition.getIsFileOverride());
            globalConfig.setActiveRecord(false);
            globalConfig.setSwagger2(true);
            globalConfig.setEnableCache(false);
            globalConfig.setBaseResultMap(true);
            globalConfig.setBaseColumnList(true);
            globalConfig.setOpen(false);
            if (StringUtils.isBlank(condition.getAuthor())) {
                log.error("请输入作者信息");
            } else {
                globalConfig.setAuthor(condition.getAuthor());
                globalConfig.setMapperName("%sMapper");
                globalConfig.setXmlName("%sMapper");
                globalConfig.setServiceName("%sService");
                globalConfig.setServiceImplName("%sServiceImpl");
                globalConfig.setControllerName("%sController");
                globalConfig.setDateType(DateType.ONLY_DATE);
                autoGenerator.setGlobalConfig(globalConfig);
                if (StringUtils.isBlank(condition.getUsername())) {
                    log.error("请配置数据库用户名");
                } else if (StringUtils.isBlank(condition.getPassword())) {
                    log.error("请配置数据库密码");
                } else if (StringUtils.isBlank(condition.getUrl())) {
                    log.error("请配置数据库url");
                } else {
                    DataSourceConfig dataSourceConfig = new DataSourceConfig();
                    dataSourceConfig.setDbType(DbType.MYSQL);
                    dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
                    dataSourceConfig.setUsername(condition.getUsername());
                    dataSourceConfig.setPassword(condition.getPassword());
                    dataSourceConfig.setUrl(condition.getUrl());
                    autoGenerator.setDataSource(dataSourceConfig);
                    if (null != condition.getTableName() && condition.getTableName().length != 0) {
                        StrategyConfig strategyConfig = new StrategyConfig();
                        strategyConfig.setTablePrefix(condition.getTablePre());
                        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
                        strategyConfig.setInclude(condition.getTableName());
                        strategyConfig.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");
                        String templatePath;
                        if (StringUtils.isNoneBlank(new CharSequence[]{condition.getBaseEntity()})) {
                            String superEntityClass = null;
                            String[] superEntityColumns = null;
                            templatePath = condition.getBaseEntity();
                            byte var10 = -1;
                            switch(templatePath.hashCode()) {
                                case 3076014:
                                    if (templatePath.equals("date")) {
                                        var10 = 0;
                                    }
                                    break;
                                case 3526476:
                                    if (templatePath.equals("self")) {
                                        var10 = 3;
                                    }
                                    break;
                                case 93508654:
                                    if (templatePath.equals("basic")) {
                                        var10 = 2;
                                    }
                                    break;
                                case 2022406093:
                                    if (templatePath.equals("logicDel")) {
                                        var10 = 1;
                                    }
                            }

                            switch(var10) {
                                case 0:
                                    superEntityClass = "com.alibaba.lcc.common.generator.entity.DateEntity";
                                    superEntityColumns = new String[]{"create_time", "update_time"};
                                    break;
                                case 1:
                                    superEntityClass = "com.alibaba.lcc.common.generator.entity.LogicDelEntity";
                                    superEntityColumns = new String[]{"is_del"};
                                    break;
                                case 2:
                                    superEntityClass = "com.alibaba.lcc.common.generator.entity.BasicEntity";
                                    superEntityColumns = new String[]{"create_time", "update_time", "is_del"};
                                    break;
                                case 3:
                                    if (StringUtils.isBlank(condition.getSelfBaseEntityPath()) || null == condition.getSelfBaseEntityCommon() || condition.getSelfBaseEntityCommon().length == 0) {
                                        log.error("请填写自定义父类全路径和公共字段数组");
                                        return;
                                    }

                                    superEntityClass = condition.getSelfBaseEntityPath();
                                    superEntityColumns = condition.getSelfBaseEntityCommon();
                            }

                            if (null != superEntityClass && null != superEntityColumns) {
                                strategyConfig.setSuperEntityClass(superEntityClass);
                                strategyConfig.setSuperEntityColumns(superEntityColumns);
                            }
                        }

                        strategyConfig.setEntityLombokModel(true);
                        strategyConfig.setRestControllerStyle(true);
                        strategyConfig.setControllerMappingHyphenStyle(true);
                        strategyConfig.setLogicDeleteFieldName("is_del");
                        autoGenerator.setStrategy(strategyConfig);
                        PackageConfig packageConfig = new PackageConfig();
                        if (StringUtils.isBlank(condition.getParentPackage())) {
                            log.error("请输入父包名");
                        } else {
                            packageConfig.setParent(condition.getParentPackage());
                            packageConfig.setController("controller");
                            packageConfig.setService("service");
                            packageConfig.setServiceImpl("service.impl");
                            packageConfig.setMapper("mapper");
                            packageConfig.setEntity("entity");
                            autoGenerator.setPackageInfo(packageConfig);
                            InjectionConfig cfg = new InjectionConfig() {
                                public void initMap() {
                                }
                            };
                            autoGenerator.setTemplateEngine(new VelocityTemplateEngine());
                            templatePath = "/template/mapper.xml.vm";
                            List<FileOutConfig> focList = new ArrayList();
                            if (condition.isXml()) {
                                focList.add(new FileOutConfig(templatePath) {
                                    public String outputFile(TableInfo tableInfo) {
                                        return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + ".xml";
                                    }
                                });
                                cfg.setFileOutConfigList(focList);
                            } else {
                                cfg.setFileOutConfigList((List)null);
                            }

                            autoGenerator.setCfg(cfg);
                            TemplateConfig templateConfig = new TemplateConfig();
                            if (condition.isController()) {
                                templateConfig.setController("/template/controller.java");
                            } else {
                                templateConfig.setController((String)null);
                            }

                            if (condition.isEntity()) {
                                templateConfig.setEntity("/template/entity.java");
                            } else {
                                templateConfig.setEntity((String)null);
                            }

                            if (condition.isMapper()) {
                                templateConfig.setMapper("/template/mapper.java");
                                templateConfig.setXml((String)null);
                            } else {
                                templateConfig.setMapper((String)null);
                                templateConfig.setXml((String)null);
                            }

                            if (condition.getIsService()) {
                                templateConfig.setService("/template/service.java");
                            } else {
                                templateConfig.setService((String)null);
                            }

                            if (condition.getIsServiceImpl()) {
                                templateConfig.setServiceImpl("/template/serviceImpl.java");
                            } else {
                                templateConfig.setServiceImpl((String)null);
                            }

                            autoGenerator.setTemplate(templateConfig);
                            autoGenerator.execute();
                        }
                    } else {
                        log.error("请填写要生成的表");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        GeneratorCondition generatorCondition = new GeneratorCondition();
        generatorCondition.setAuthor("lccsetsun");
        generatorCondition.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&zeroDateTimeBehavior=CONVERT_TO_NULL&allowMultiQueries=true");
        generatorCondition.setUsername("root");
        generatorCondition.setPassword("lccsetsun.github.io");
        generatorCondition.setParentPackage("com.alibaba.lcc.c");
        generatorCondition.setTablePre(new String[]{"tb"});
        generatorCondition.setTableName(new String[]{"tb_form_metadata_info"});
        generatorCondition.setIsFileOverride(true);
        generator(generatorCondition);
    }
}