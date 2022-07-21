package com.test.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 何乐
 * @date 2021/03/11 14:46
 * @desc 基础审计DO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "基础审计DO", description = "包含一些审计字段")
public class BaseAuditDO extends BaseIdDO {

    private static final long serialVersionUID = 5854321311151751108L;

    /**
     * 创建者ID
     **/
    @TableField(value = "CREATE_ID", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建者ID")
    private String createId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    public Date createTime;

    /**
     * 最近修改者ID
     **/
    @ApiModelProperty(value = "最近修改者ID")
    @TableField(value = "UPDATE_ID", fill = FieldFill.INSERT_UPDATE)
    private String updateId;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "UPDATE_TIME", fill = FieldFill.INSERT_UPDATE)
    public Date updateTime;

    /**
     * 逻辑删除标识
     */
    @ApiModelProperty("逻辑删除标识，'0' = 否 ，'1' = 是")
    @TableField(value = "DELETED")
    @TableLogic
    private String deleted;

}
