package com.alibaba.alibaba;

import com.alibaba.fastjson.JSON;
import com.alibaba.lcc.model.model.MetaInfo;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {
    public static String INTEGER = "java.lang.Integer";
    public static String LONG = "java.lang.Long";
    public static String STRING = "java.lang.String";
    public static String JSONOBJECT = "com.alibaba.fastjson.JSONObject";
    public static String FLOAT = "java.lang.Float";
    public static String DOUBLE = "java.lang.Double";
    public static String BIG_DECIMAL = "java.math.BigDecimal";
    public static String DATE = "java.util.Date";

    public static String strjson = " [\n" +
            "    {\n" +
            "        \"objType\":\"person\",\n" +
            "        \"dbTableName\":\"person_result\",\n" +
            "        \"indexName\": \"person_index\",\n" +
            "\t    \"indexMode\": \"INDEX_PER_DAY\",\n" +
            "        \"topicName\": \"person\",\n" +
            "        \"fields\": [ {\n" +
            "            \"name\":\"cameraId\",\n" +
            "            \"type\":\"string\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"objType\",\n" +
            "            \"type\":\"string\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"objLeft\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"objTop\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"objRight\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"objBottom\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"origImage\",\n" +
            "            \"type\":\"string\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"cropImage\",\n" +
            "            \"type\":\"string\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"timestamp\",\n" +
            "            \"type\":\"long\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"entryTime\",\n" +
            "            \"type\":\"long\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"leaveTime\",\n" +
            "            \"type\":\"long\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"feature\",\n" +
            "            \"type\":\"binary\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": false,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": false\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"sex\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "\t   {\n" +
            "            \"name\":\"sexScore\",\n" +
            "            \"type\":\"float\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"age\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "\t   {\n" +
            "            \"name\":\"ageScore\",\n" +
            "            \"type\":\"float\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"hair\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "\t   {\n" +
            "            \"name\":\"hairScore\",\n" +
            "            \"type\":\"float\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"pose\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "\t   {\n" +
            "            \"name\":\"poseScore\",\n" +
            "            \"type\":\"float\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"clothType\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "\t   {\n" +
            "            \"name\":\"clothTypeScore\",\n" +
            "            \"type\":\"float\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"clothColor\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "\t   {\n" +
            "            \"name\":\"clothColorScore\",\n" +
            "            \"type\":\"float\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"trouserType\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "\t   {\n" +
            "            \"name\":\"trouserTypeScore\",\n" +
            "            \"type\":\"float\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"trouserColor\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "\t   {\n" +
            "            \"name\":\"trouserColorScore\",\n" +
            "            \"type\":\"float\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        }]\n" +
            "    },\n" +
            "    {\n" +
            "        \"objType\":\"vehicle\",\n" +
            "        \"dbTableName\":\"vehicle_result\",\n" +
            "        \"indexName\": \"vehicle_index\",\n" +
            "\t    \"indexMode\": \"INDEX_PER_DAY\",\n" +
            "        \"topicName\": \"vehicle\",\n" +
            "        \"fields\": [ {\n" +
            "            \"name\":\"cameraId\",\n" +
            "            \"type\":\"string\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"objType\",\n" +
            "            \"type\":\"string\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"objLeft\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"objTop\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"objRight\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"objBottom\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"origImage\",\n" +
            "            \"type\":\"string\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"cropImage\",\n" +
            "            \"type\":\"string\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"timestamp\",\n" +
            "            \"type\":\"long\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"entryTime\",\n" +
            "            \"type\":\"long\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"leaveTime\",\n" +
            "            \"type\":\"long\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"feature\",\n" +
            "            \"type\":\"binary\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": false,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": false\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"color\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "\t   {\n" +
            "            \"name\":\"colorScore\",\n" +
            "            \"type\":\"float\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"type\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "\t   {\n" +
            "            \"name\":\"typeScore\",\n" +
            "            \"type\":\"float\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"brand\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "\t   {\n" +
            "            \"name\":\"brandScore\",\n" +
            "            \"type\":\"float\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        }]\n" +
            "    },\n" +
            "    {\n" +
            "        \"objType\":\"bicycle\",\n" +
            "        \"dbTableName\":\"bicycle_result\",\n" +
            "        \"indexName\": \"bicycle_index\",\n" +
            "\t    \"indexMode\": \"INDEX_PER_DAY\",\n" +
            "        \"topicName\": \"bicycle\",\n" +
            "        \"fields\": [ {\n" +
            "            \"name\":\"cameraId\",\n" +
            "            \"type\":\"string\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"objType\",\n" +
            "            \"type\":\"string\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"objLeft\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"objTop\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"objRight\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"objBottom\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"origImage\",\n" +
            "            \"type\":\"string\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"cropImage\",\n" +
            "            \"type\":\"string\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"timestamp\",\n" +
            "            \"type\":\"long\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"entryTime\",\n" +
            "            \"type\":\"long\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"leaveTime\",\n" +
            "            \"type\":\"long\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"feature\",\n" +
            "            \"type\":\"binary\",\n" +
            "            \"mandatory\":true,\n" +
            "            \"isDatabaseField\": false,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": false\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"sex\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "\t   {\n" +
            "            \"name\":\"sexScore\",\n" +
            "            \"type\":\"float\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"age\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "\t   {\n" +
            "            \"name\":\"ageScore\",\n" +
            "            \"type\":\"float\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"headWear\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "\t   {\n" +
            "            \"name\":\"headWearScore\",\n" +
            "            \"type\":\"float\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"bycleType\",\n" +
            "            \"type\":\"integer\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        },\n" +
            "\t   {\n" +
            "            \"name\":\"bycleTypeScore\",\n" +
            "            \"type\":\"float\",\n" +
            "            \"mandatory\":false,\n" +
            "            \"isDatabaseField\": true,\n" +
            "            \"isSearchEngineField\": true,\n" +
            "            \"isMessageQueueField\": true\n" +
            "        }]\n" +
            "    }\n" +
            "] ";

    public static String tmp_json =
            "[{\"objType\":\"person\",\"dbTableName\":\"person_result\",\"topicName\":\"person\"}]";
    public static void main(String[] args) {
        String key = "str准确率";
        String valueType = "1234";
        String jsons = replaceBlank(strjson);
//        System.out.println(jsons);

        List<MetaInfo> metaInfo = JSON.parseArray(strjson,MetaInfo.class);
        for (int i = 0; i <metaInfo.size() ; i++) {
            List<MetaInfo.FieldsBean> fieldsBean = metaInfo.get(i).getFields();
            for (int j = 0; j <fieldsBean.size() ; j++) {
                MetaInfo.FieldsBean field = fieldsBean.get(j);
                System.out.println(field.getName() + " type :" + field.getType());
            }
        }

    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }


}
