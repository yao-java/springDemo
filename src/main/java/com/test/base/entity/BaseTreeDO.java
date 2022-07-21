package com.test.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 何乐
 * @date 2021/03/11 14:59
 * @desc 树形实体基础DO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "树形实体基础DO", description = "审计字段")
public class BaseTreeDO extends BaseAuditDO {

    /**
     * 直系父ID
     **/
    @ApiModelProperty(value = "直系父ID")
    @TableField(value = "PARENT_ID")
    private String parentId;

    /**
     * 父ID集合
     **/
    @ApiModelProperty(value = "父ID集合形如：'grandParentId,parentId,selfId'")
    @TableField(value = "PARENT_IDS")
    private String parentIds;
}
