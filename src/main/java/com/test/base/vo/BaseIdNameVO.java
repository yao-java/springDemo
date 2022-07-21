package com.test.base.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 创建时间：2019年01月22日 15:44
 * 用途：
 *
 * @author hele
 */
@ApiModel
@Data
public class BaseIdNameVO extends BaseIdVO {
    private static final long serialVersionUID = -6364731738087774288L;

    @ExcelIgnore
    @ApiModelProperty("名称")
    private String name;
}
