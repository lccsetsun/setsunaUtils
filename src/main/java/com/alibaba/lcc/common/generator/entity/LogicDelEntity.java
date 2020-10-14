package com.alibaba.lcc.common.generator.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;

public class LogicDelEntity implements Serializable {
    private static final long serialVersionUID = -2788794983647427559L;
    @TableLogic
    @TableField(
            select = false,
            fill = FieldFill.INSERT
    )
    private Integer isDel;

    public LogicDelEntity() {
    }

    public Integer getIsDel() {
        return this.isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}
