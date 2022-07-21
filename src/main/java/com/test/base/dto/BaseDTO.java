package com.test.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author hele
 * @创建时间: 2020/05/14 14:20
 * @描述: 基础DTO
 */
@Data
@ApiModel("基础DTO")
public class BaseDTO extends BaseIdDTO {
    @ApiModelProperty(value = "名称")
    public String name;
}
