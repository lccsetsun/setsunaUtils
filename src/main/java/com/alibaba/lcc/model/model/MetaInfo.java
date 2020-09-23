package com.alibaba.lcc.model.model;

import java.util.List;

public class MetaInfo {


    /**
     * objType : person
     * dbTableName : person_result
     * indexName : person_index
     * indexMode : INDEX_PER_DAY
     * topicName : person
     * fields : [{"name":"cameraId","type":"string","mandatory":true,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"objType","type":"string","mandatory":true,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"objLeft","type":"integer","mandatory":true,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"objTop","type":"integer","mandatory":true,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"objRight","type":"integer","mandatory":true,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"objBottom","type":"integer","mandatory":true,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"origImage","type":"string","mandatory":true,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"cropImage","type":"string","mandatory":true,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"timestamp","type":"long","mandatory":true,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"entryTime","type":"long","mandatory":true,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"leaveTime","type":"long","mandatory":true,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"feature","type":"binary","mandatory":true,"isDatabaseField":false,"isSearchEngineField":true,"isMessageQueueField":false},{"name":"sex","type":"integer","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"sexScore","type":"float","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"age","type":"integer","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"ageScore","type":"float","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"hair","type":"integer","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"hairScore","type":"float","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"pose","type":"integer","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"poseScore","type":"float","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"clothType","type":"integer","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"clothTypeScore","type":"float","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"clothColor","type":"integer","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"clothColorScore","type":"float","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"trouserType","type":"integer","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"trouserTypeScore","type":"float","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"trouserColor","type":"integer","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true},{"name":"trouserColorScore","type":"float","mandatory":false,"isDatabaseField":true,"isSearchEngineField":true,"isMessageQueueField":true}]
     */

    private String objType;
    private String dbTableName;
    private String indexName;
    private String indexMode;
    private String topicName;
    private List<FieldsBean> fields;

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getDbTableName() {
        return dbTableName;
    }

    public void setDbTableName(String dbTableName) {
        this.dbTableName = dbTableName;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getIndexMode() {
        return indexMode;
    }

    public void setIndexMode(String indexMode) {
        this.indexMode = indexMode;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public List<FieldsBean> getFields() {
        return fields;
    }

    public void setFields(List<FieldsBean> fields) {
        this.fields = fields;
    }

    public static class FieldsBean {
        /**
         * name : cameraId
         * type : string
         * mandatory : true
         * isDatabaseField : true
         * isSearchEngineField : true
         * isMessageQueueField : true
         */

        private String name;
        private String type;
        private boolean mandatory;
        private boolean isDatabaseField;
        private boolean isSearchEngineField;
        private boolean isMessageQueueField;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isMandatory() {
            return mandatory;
        }

        public void setMandatory(boolean mandatory) {
            this.mandatory = mandatory;
        }

        public boolean isIsDatabaseField() {
            return isDatabaseField;
        }

        public void setIsDatabaseField(boolean isDatabaseField) {
            this.isDatabaseField = isDatabaseField;
        }

        public boolean isIsSearchEngineField() {
            return isSearchEngineField;
        }

        public void setIsSearchEngineField(boolean isSearchEngineField) {
            this.isSearchEngineField = isSearchEngineField;
        }

        public boolean isIsMessageQueueField() {
            return isMessageQueueField;
        }

        public void setIsMessageQueueField(boolean isMessageQueueField) {
            this.isMessageQueueField = isMessageQueueField;
        }
    }
}
