package com.test.base.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 创建时间：2019年01月17日 17:51
 * 用途：
 *
 * @author hele
 */
@Data
@ApiModel
public class BaseIdVO implements Serializable {
    private static final long serialVersionUID = -8329756797870137660L;

    @ExcelIgnore
    @ApiModelProperty(value = "ID值")
    public String id;
}
