package com.alibaba.lcc.common.generator.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BasicEntity implements Serializable {
    private static final long serialVersionUID = -2817722542718460286L;
    @TableField(
            fill = FieldFill.INSERT
    )
    private LocalDateTime createTime;
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private LocalDateTime updateTime;
    @TableLogic
    @TableField(
            select = false,
            fill = FieldFill.INSERT
    )
    private Integer isDel;

    public BasicEntity() {
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDel() {
        return this.isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}
