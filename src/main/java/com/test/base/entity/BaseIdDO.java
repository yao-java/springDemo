package com.test.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 何乐
 * @date 2021/03/11 14:36
 * @desc 基础DO，只包含ID
 */
@Data
public class BaseIdDO implements Serializable {

    private static final long serialVersionUID = 1671841718568509574L;

    /**
     * 主键ID
     **/
    @ApiModelProperty(value = "主键ID")
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

}
