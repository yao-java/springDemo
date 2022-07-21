package com.test.base.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 何乐
 * @date 2020/05/14 14:17
 * @desc 基础查询VO
 */
@Data
@ApiModel("基础查询VO")
public class BaseQueryVO implements Serializable {
    private static final long serialVersionUID = -1;

    @ApiModelProperty(value = "id")
    public String id;
    @ApiModelProperty(value = "名称")
    public String name;
}
