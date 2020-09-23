package com.alibaba.lcc.model.resp;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: setsun
 * @Description: 分页信息
 * @Date: 9:39 2018/6/5
 */
@Setter
@Getter
public class PageInfo implements Serializable {

    private Integer page = 1;

    private Integer rows = 10;

    private Integer Start;  //查询起始页

    public int getStart() {
        return (page - 1) * rows;
    }

}
