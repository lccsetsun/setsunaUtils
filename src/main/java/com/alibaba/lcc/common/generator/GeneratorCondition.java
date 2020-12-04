package com.alibaba.lcc.common.generator;

import lombok.Data;
/**
* author: 夕阳
* date: 2020/10/14
* Description: 自动生成实体类配置项
 *  需要注意的字段 数据url 要和现有的 mysql驱动版本相符合
 *  modelName ： 多模块的情况写模块名称 当前模块 ./
 *
*/
@Data
public class GeneratorCondition {
    private String url;
    private String username;
    private String password;
    private String author;
    private boolean isMultiModule = false;
    private String modelName;
    private String parentPackage;
    private boolean isFileOverride = false;
    private boolean isEntity = true;
    private boolean isMapper = true;
    private boolean isXml = true;
    private boolean isService = true;
    private boolean isServiceImpl = true;
    private boolean isController = true;
    private String baseEntity;
    private String selfBaseEntityPath;
    private String[] selfBaseEntityCommon;
    private String[] tablePre;
    private String[] tableName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean getIsMultiModule() {
        return isMultiModule;
    }

    public void setIsMultiModule(boolean multiModule) {
        isMultiModule = multiModule;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getParentPackage() {
        return parentPackage;
    }

    public void setParentPackage(String parentPackage) {
        this.parentPackage = parentPackage;
    }

    public boolean getIsFileOverride() {
        return isFileOverride;
    }

    public void setIsFileOverride(boolean fileOverride) {
        isFileOverride = fileOverride;
    }

    public boolean isEntity() {
        return isEntity;
    }

    public void setEntity(boolean entity) {
        isEntity = entity;
    }

    public boolean isMapper() {
        return isMapper;
    }

    public void setMapper(boolean mapper) {
        isMapper = mapper;
    }

    public boolean isXml() {
        return isXml;
    }

    public void setXml(boolean xml) {
        isXml = xml;
    }

    public boolean getIsService() {
        return isService;
    }

    public void setService(boolean service) {
        isService = service;
    }

    public boolean getIsServiceImpl() {
        return isServiceImpl;
    }

    public void setServiceImpl(boolean serviceImpl) {
        isServiceImpl = serviceImpl;
    }

    public boolean isController() {
        return isController;
    }

    public void setController(boolean controller) {
        isController = controller;
    }

    public String getBaseEntity() {
        return baseEntity;
    }

    public void setBaseEntity(String baseEntity) {
        this.baseEntity = baseEntity;
    }

    public String getSelfBaseEntityPath() {
        return selfBaseEntityPath;
    }

    public void setSelfBaseEntityPath(String selfBaseEntityPath) {
        this.selfBaseEntityPath = selfBaseEntityPath;
    }

    public String[] getSelfBaseEntityCommon() {
        return selfBaseEntityCommon;
    }

    public void setSelfBaseEntityCommon(String[] selfBaseEntityCommon) {
        this.selfBaseEntityCommon = selfBaseEntityCommon;
    }

    public String[] getTablePre() {
        return tablePre;
    }

    public void setTablePre(String[] tablePre) {
        this.tablePre = tablePre;
    }

    public String[] getTableName() {
        return tableName;
    }

    public void setTableName(String[] tableName) {
        this.tableName = tableName;
    }
}
